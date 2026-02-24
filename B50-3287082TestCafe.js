import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3287082TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3287082TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Open the bandbox.</li>
			<li>Focus in the input of the paging.</li>
			<li>Remove "1", then type "2".</li>
			<li>"no fire" shall not become to "fire".</li>
		</ol>
	]]></html>
	<bandbox onChanging=\'msg.value = fire\'>
		<bandpopup width="300px">
			<grid mold="paging" pageSize="3">
				<rows>
					<row forEach="1,1,1,1,1">
						<label value="item" />
					</row>
				</rows>
			</grid>
		</bandpopup>
	</bandbox>
	<label id="msg" value="no fire"/>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-paging-input")[0]),
		ztl.normalizeText("2"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("no fire"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("msg", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});

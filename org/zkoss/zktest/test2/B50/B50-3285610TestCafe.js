import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3285610TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3285610TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Inplace editor doesn\'t remove the border when focus out</li>
		</ol>
	]]></html>

	<textbox id="test1" inplace="true" onFocus="tb.focus();" value="text1"/>
	<textbox id="tb" inplace="true" value="text2"/>
</zk>`,
	);
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("test1", true)).focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-textbox").css("box-shadow"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t.expect("true").ok();
});

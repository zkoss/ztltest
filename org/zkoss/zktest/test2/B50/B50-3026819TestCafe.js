import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3026819TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3026819TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
	<li>Click tab to navigator each textbox</li>
	<li>Check it will skip second textbox</li>
</ol>
]]>
</html>
	<div>
		<textbox id="txt1" value="tabindex1" />
		<textbox id="txt2" value="tabindex-1" tabindex="-1" />
		<textbox id="txt3" value="tabindex2" />
	</div>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("txt1", true).$n().focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("txt3", true)).css("box-shadow"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
});

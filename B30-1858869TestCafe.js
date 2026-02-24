import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1858869TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1858869TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="w" title="Test of textbox with onOK">
	<textbox id="test" onOK="test()"/>
	<zscript>
void test() {
	new Label(test.getValue()).setParent(w);
}
	</zscript>
</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.typeText(
		Selector(() => jq("$test")[0]),
		ztl.normalizeText("I am test string"),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$test").focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("I am test string"));
});

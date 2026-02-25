import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2990657TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2990657TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Set Combobox autocomplete="false" doesn\'t work, still has autocomplete</div>
				<div>Type in the combobox "ab" and press enter, the text in the combobox should be "ab", not "abacus"</div>
				
				<combobox id="combo" autodrop="true" autocomplete="false"/>
				<zscript>
				String[] _dict = { 
					"abacus", "accuracy", "acuity", "adage", "afar", "after", "apple",
					"jump", "jungle", "jungle fever"
				};
				 ListModel dictModel= new SimpleListModel(_dict);
				 combo.setModel(dictModel);
				</zscript>
			</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("combo", true).$n("real").focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("combo", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Desktop._dt.$f("combo", true).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("a b enter");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("ab"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3014660TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3014660TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please type "abx" into the combobox, and then you should see "ab" in the combobox.
<combobox id="combo" autodrop="true">
<attribute name="onChanging"><![CDATA[
if (event.getValue().equals("abx")) {
self.setValue("ab");
}
]]></attribute>
</combobox>
<zscript><![CDATA[
String[] _dict = { "abacus", "accuracy" };
ListModel dictModel = new SimpleListModel(_dict);
combo.setModel(dictModel);
]]></zscript>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("combo", true).focus();
	})();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("combo", true).$n("real")),
		ztl.normalizeText("abx"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("combo", true).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("ab"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2848692TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2848692TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
0: Use IE
<separator/>
1.Please select the first item from the combobox, and then click the OK button.
<separator/>
2.You should see the result is "CMB selected = 0"
<combobox id="cmb">
<comboitem label=\'Valor1  "\'/>\n</combobox>\n<button id="ok" label="OK" onClick=\'alert("CMB selected = "\n+ cmb.getSelectedIndex())\'/>\n</zk>`,
	);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("CMB selected = 0"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2914048TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2914048TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1.Please click "orient" button, and then click "append" button.
<separator/>
2. You can see that the new "Append 1" label is added next to "Second"
<box id="box">
First
<label value="Second"/>
</box>
<zscript>int cnt;
</zscript>
<button label="orient" onClick=\'box.setOrient(box.vertical?"horizontal":"vertical")\'/>
<button label="append" onClick=\'new Label("Append "+ ++cnt).setParent(box)\'/>
</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="orient"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="append"]')[0]));
	await ztl.waitResponse(t);
	let s1_cafe = await ClientFunction(() =>
		jq('@label[value="Second"]').parent().next().next().html(),
	)();
	let s2_cafe = await ClientFunction(() =>
		jq('@label[value="Append 1"]').parent().html(),
	)();
	await t.expect(ztl.normalizeText(s2_cafe)).eql(ztl.normalizeText(s1_cafe));
});

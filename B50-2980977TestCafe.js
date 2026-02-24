import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2980977TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2980977TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<grid>
			<rows>
			<row>
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row id="row">
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row>
			<label value="Options:"/>
			<textbox rows="3" width="98%"/>
			</row>
			</rows>
			</grid>
			<button id="btn" label="Click Me you should see the stripe still exists."
			onClick=\'row.setSpans("1,1")\'/>
			<button id="btn2" label="Click Me you should see the stripe still exists."
			onClick=\'row.setClass("abc")\'/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("row", true)).hasClass("z-row z-grid-odd"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("row", true)).hasClass("z-row z-grid-odd"),
			)(),
		)
		.ok();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2448TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2448TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. click the button
	2. you should see the listbox is filled without scroll bar
	</label>
	<button id="addListheaders" label="add list headers to cause JS error"/>
	<!-- whether "span" attribute is specified, hflex should work -->
	<listbox span="true" width="300px">
		<listhead fulfill="addListheaders.onClick">
			<listheader label="aaa" hflex="min"></listheader>
			<listheader label="bbb" hflex="min"></listheader>
			<listheader label="ccc" hflex="min"></listheader>
		</listhead>
		<listitem>
			<listcell>Long Content</listcell>
			<listcell>Shorter</listcell>
			<listcell>tiny</listcell>
		</listitem>
	</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 0).ok();
});

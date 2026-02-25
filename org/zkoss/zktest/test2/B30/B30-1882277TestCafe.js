import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1882277TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1882277TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:p>Click tab1 and then click tab2, you should see the tabpanel of tab2 with scrollbar(Safari only).</n:p>
<tabbox width="400px" mold="accordion">
	<tabs>
		<tab label="Tab 1"/>
		<tab label="Tab 2" selected="true"/>
	</tabs>
	<tabpanels>
		<tabpanel height="100px" style="background:yellow">This
		is panel 1</tabpanel>
		<tabpanel height="100px"
		style="background:blue;overflow:auto">This is panel 2
		<div height="200px">___</div>The second panel
		</tabpanel>
	</tabpanels>
</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-tab").eq(0)[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-tabpanel-content:eq(0)")[0].scrollHeight,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-tabpanel-content:eq(0)").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_1_1 >= verifyVariable_cafe_0_0).ok();
	await t.click(Selector(() => jq(".z-tab").eq(1)[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-tabpanel-content:eq(1)")[0].scrollHeight,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-tabpanel-content:eq(1)").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_3_3 < verifyVariable_cafe_2_2).ok();
});

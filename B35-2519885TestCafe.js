import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2519885TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2519885TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        1. Check two or three rows on first page.
        <separator/>
        2. Click the next button to go to the next page.
        <separator/>
        3. Check one row (you must check on the checkbox, not on the row), and then click the previous button to go back to first page.
        <separator/>
        4. You should see the first step checking some rows should be remained.
        <zscript>
          <![CDATA[
          import org.zkoss.zktest.test2.tree.BinaryTreeModel;
	
	BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
]]>
        </zscript>
        <tree id="tree" mold="paging" pageSize="15" model="&#36;{btm}" checkmark="true" multiple="true">
          <attribute name="onCreate">
            <![CDATA[
		tree.renderItemByPath(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
		tree.renderItemByPath(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
]]>
          </attribute>
        </tree>
      </zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-treerow-selected").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 0)
		.ok("It should not be a selected nodes");
	await t
		.click(Selector(() => jq(".z-treerow")[2]))
		.click(Selector(() => jq(".z-treerow")[4]))
		.click(Selector(() => jq(".z-treerow")[6]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-treerow-selected").length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 == 3)
		.ok("It should be three selected nodes");
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow")[1]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-treerow-selected").length,
	)();
	await t
		.expect(verifyVariable_cafe_2_2 == 3)
		.ok("It should be three selected nodes");
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-treerow-selected").length,
	)();
	await t
		.expect(verifyVariable_cafe_3_3 == 1)
		.ok("It should be one selected node on this page");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2375TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2375TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<zk>
    <label multiline="true">
    1. Open tree node 1, 3, 7, 15, 31, 63, 127, 255
    2. Navigate to page 2 then navigate back to page 1
    3. Close tree node 255
    4. Should see tree node 4, 8 (bug if not seeing).
    </label>
    <window apply="org.zkoss.bind.BindComposer" viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.test2.B70_ZK_2375_TreeVM\')">
        <paging id="paging" pageSize="15" totalSize="@load(vm.totalsize)" />
        <tree id="tree" model="@load(vm.model)" mold="paging" paginal="\${paging}" rows="15">
            <treecols>
                <treecol label="Col" />
            </treecols>
            <template name="model" var="each">
                <treeitem value="@load(each)">
                    <treerow>
                        <treecell label="t\${each}" />
                    </treerow>
                </treeitem>
            </template>
        </tree>
    </window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-tree-icon").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(4)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(5)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(6)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(7)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon").eq(7)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("span.z-treecell-text:contains(t8)")[0],
			)(),
		)
		.ok("node t8 should exist.");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-707-TreeModelTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-707-TreeModelTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test share TreeModel" border="normal">
			<zscript><![CDATA[
			ListModelList lm = new ListModelList(Arrays.asList(new String[]{"David", "Thomas","Steven"}));
					stm = new DefaultTreeModel(new DefaultTreeNode("ROOT",
							new DefaultTreeNode[]{
									new DefaultTreeNode("David"), 
									new DefaultTreeNode("Thomas"),
									new DefaultTreeNode("Steven")}));
					
					
					ArrayList list = new ArrayList();
					ArrayList list2 = new ArrayList();
					int len = 10;
					for(int i = 0; i < len; i++) {
						list.add("item " + i);
						list2.add(new DefaultTreeNode("item " + i));
					}
					ListModelList lm2 = new ListModelList(list);
					
					stm2 = new DefaultTreeModel(
							new DefaultTreeNode("ROOT", 
									Arrays.asList(new DefaultTreeNode[]{new DefaultTreeNode("root",list2)})));
			]]></zscript>
			Please test to open/close/select the treeitem, the both tree should be the same result.
			<tree id="treeOne" model="\${stm2}" mold="paging" pageSize="3" onSelect="">
			<template name="model">
			<treeitem label="\${each.data}"/>
			</template>
			</tree>
			<tree id="treeTwo" model="\${stm2}" onSelect="">
			<template name="model">
			<treeitem label="\${each.data}"/>
			</template>
			</tree>
			</window>`,
	);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeOne", true)).find(".z-treerow"),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeOne", true)).find(
							".z-treerow",
						),
					).$n("icon") != null,
			)(),
		)
		.ok("First tree should opened");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeTwo", true)).find(
							".z-treerow",
						),
					).$n("icon") != null,
			)(),
		)
		.ok("Second Tree should opened as first tree");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeTwo", true)).find(".z-treerow"),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeTwo", true)).find(
							".z-treerow",
						),
					).$n("icon") != null,
			)(),
		)
		.ok("Second tree should closed");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeOne", true)).find(
							".z-treerow",
						),
					).$n("icon") != null,
			)(),
		)
		.ok("First Tree should closed as second tree");
});

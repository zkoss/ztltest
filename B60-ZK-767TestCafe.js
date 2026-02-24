import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-767TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-767TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript><![CDATA[//@DECLARATION
			       	class MyTreeNode extends org.zkoss.zul.DefaultTreeNode {
			       		public MyTreeNode(String data, MyTreeNode[] children) {
			      			super(data, children);
			      		}
			      		public MyTreeNode(String data) {
			      			super(data);
			      		}
			      	}
				]]></zscript>
				<zscript><![CDATA[
					MyTreeNode root = new MyTreeNode("Root", new MyTreeNode[] {});
					String[] labs = new String[] { "A", "B", "C" };
					for (int i = 0; i < 3; i++) {
						MyTreeNode ni = new MyTreeNode(labs[i] + i, new MyTreeNode[] {});
						for (int j = 0; j < 3; j++) {
							MyTreeNode nj = new MyTreeNode(ni.getData() + "-" + j, new MyTreeNode[] {});
							for (int k = 0; k < 2; k++)
								nj.add(new MyTreeNode(nj.getData() + "-" + k));
							ni.add(nj);
						}
						root.add(ni);
					}
					org.zkoss.zul.DefaultTreeModel model = new org.zkoss.zul.DefaultTreeModel(root);
					org.zkoss.zul.DefaultTreeModel model2 = new org.zkoss.zul.DefaultTreeModel(root);
					model.addSelectionPath(new int[] { 1, 1 });
					model.addOpenPath(new int[] { 0, 1 });
				]]></zscript>
				<div>
					<div>1. Open A0 in Tree 1. You should see A0-1 already opened.</div>
					<div>2. Open B1 in Tree 1. You should see B1-1 already selected.</div>
					<div>3. Click "Open 0,1", and open A0 in Tree 2. You should see A0-1 already opened.</div>
					<div>4. Click "Select 1,1", and open B1 in Tree 2. You should see B1-1 already selected.</div>
				</div>
				<separator />
				Tree 1
				<tree id="treeOne" model="\${model}" width="500px">
					<treecols>
						<treecol label="name"/>
					</treecols>
					<template name="model" >
						<treeitem value="\${each}">
							<treerow>
								<treecell label="\${each.data}"/>
							</treerow>
						</treeitem>
					</template>
				</tree>
				Tree 2
				<tree id="treeTwo" model="\${model2}" width="500px">
					<treecols>
						<treecol label="name"/>
					</treecols>
					<template name="model" >
						<treeitem value="\${each}">
							<treerow>
								<treecell label="\${each.data}"/>
							</treerow>
						</treeitem>
					</template>
				</tree>
				<hlayout>
					<button id="btnOne" label="Open 0,1" onClick="model2.addOpenPath(new int[]{0,1})" />
					<button id="btnTwo" label="Select 1,1" onClick="model2.addSelectionPath(new int[]{1,1})" />
				</hlayout>
			</zk>`,
	);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeOne", true).$n()).find(
					".z-treerow:contains(A0)",
				),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeOne", true)).find(
							".z-treerow:contains(A0-1)",
						),
					).$n("icon"),
				).hasClass("z-tree-open"),
			)(),
		)
		.ok("A0-1 of Tree 1 should already opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeOne", true).$n()).find(
					".z-treerow:contains(B1)",
				),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					jq(zk.Desktop._dt.$f("treeOne", true).$n()).find(
						".z-treerow.z-treerow-selected:contains(B1-1)",
					)[0] != null,
			)(),
		)
		.ok("B1-1 of Tree 1 should already selected");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeTwo", true).$n()).find(
					".z-treerow:contains(A0)",
				),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("treeTwo", true).$n()).find(
							".z-treerow:contains(A0-1)",
						),
					).$n("icon"),
				).hasClass("z-tree-open"),
			)(),
		)
		.ok("A0-1 of Tree 2 should already opened");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("treeTwo", true).$n()).find(
					".z-treerow:contains(B1)",
				),
			).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					jq(zk.Desktop._dt.$f("treeTwo", true).$n()).find(
						".z-treerow.z-treerow-selected:contains(B1-1)",
					)[0] != null,
			)(),
		)
		.ok("B1-1 of Tree 2 should already selected");
});

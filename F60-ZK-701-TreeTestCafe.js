import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-701-TreeTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-701-TreeTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<vbox id="vb">
				1. Please select one item on the tree.
				<separator />
				2. Press the "Clone" button (it should not show any exception)
				<separator />
				3. Please select another item on the top tree and then click the "Path" head to sort it.
				<separator />
				4. The sorting and the selection cannot apply to the bottom list. (That is the feature)
				<button id="btn" label="Clone">
					<attribute name="onClick">{
				Object l = tree.clone();
				l.setId("dst" + ++cnt);
				vb.insertBefore(l, self);
					}</attribute>
				</button>
			    <zscript><![CDATA[
			import org.zkoss.zk.ui.util.ComponentCloneListener;
			  int cnt = 0;
			public class CloneableModel extends org.zkoss.zul.DefaultTreeModel implements ComponentCloneListener, Cloneable {
				public CloneableModel(Object d) {
					super(d);
				}
				public Object willClone(Component comp) {
					return clone();
				}
			}
				TreeitemRenderer render = new org.zkoss.zktest.test2.tree.DirectoryTreeitemRenderer();
				DefaultTreeModel model = new CloneableModel(org.zkoss.zktest.test2.tree.PackageData.getRoot());
			    ]]></zscript>
			    <tree id="tree" width="830px" itemRenderer="\${render}" model="\${model}">
					<treecols>
						<treecol hflex="3" label="Path" sort="auto"/>
						<treecol hflex="5" label="Description" />
						<treecol hflex="2" label="Size" />
					</treecols>
				</tree>
				</vbox>
			</zk>`,
	);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree", true)).find(
					".z-treerow:contains(/src)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("tree", true)).find(
				".z-treerow-selected:contains(/src)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.ok("The item contains /src should be selected");
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() =>
			!!jq(zk.Widget.$(jq(".z-tree").eq(0))).find(
				".z-treerow-selected:contains(/src)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.ok("The item contains /src should be selected");
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-tree").eq(0))).find(
					".z-treerow:contains(/doc)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-tree").eq(0))).find(
					".z-treecol:contains(Path)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("tree", true)).find(
				".z-treerow-selected:contains(/doc)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1)
		.notOk("The item contains /doc should not be selected");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			!!jq(zk.Widget.$(jq(".z-tree").eq(0))).find(
				".z-treerow-selected:contains(/doc)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt)
		.ok("The item contains /doc should be selected");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("tree", true)).find(
							".z-treerow",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("/doc"),
			"The 0 th element should contains /doc",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Widget.$(jq(".z-tree").eq(0))).find(
							".z-treerow",
						)[5].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("/doc"),
			"The 5 th element should contains /doc",
		);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2936132TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2936132TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					If we open the tree node \'Item 1\' and click button to add \'Item 1-3\', the
					order is correct.
					<separator/>
					Reload again, If we don\'t open the tree node and click button to add \'Item
					1-3\', open the tree node \'Item 1\', the order should be correct as the same as previous.
					<separator/>
					<button id="btn" label="Add Item 1-3">
						<attribute name="onClick">
							Treeitem item = new Treeitem();
							item.setParent(treechildren1);
							Treerow row = new Treerow();
							row.setParent(item);
							row.appendChild(new Treecell("Item 1-3"));
						</attribute>
					</button>
					<separator height="50px"/>
					<tree width="500px">
						<treecols>
						<treecol label="treecol 1" />
						</treecols>
						<treechildren>
						<treeitem open="false">
						<treerow>
						<treecell label="Item 1" />
						</treerow>
						<treechildren id="treechildren1">
						<treeitem open="false">
						<treerow>
						<treecell label="Item 1-1"/>
						</treerow>
						</treeitem>
						<treeitem open="false">
						<treerow><treecell label="Item 1-2"/></treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem id="treeitem2" open="false">
						<treerow id="treerow2">
						<treecell label="Item 2" />
						</treerow>
						<treechildren>
						<treeitem>
						<treerow>
						<treecell label="Item 2-1"/>
						</treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem open="false">
						<treerow>
						<treecell label="Item 3" />
						</treerow>
						</treeitem>
						</treechildren>
					</tree>
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:eq(0)")).$n("icon")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("tr.z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-treecell:eq(1)")).$n("cave"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 1-1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-treecell:eq(2)")).$n("cave"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 1-2"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-treecell:eq(3)")).$n("cave"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 1-3"), "");
});

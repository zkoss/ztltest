import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3013126TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3013126TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1. Please select "Item 2.1"
<separator/>
2. Click the "disabled" button
<separator/>
3. The "Item 2" should not disappear.

<tree id="tree" width="400px" rows="8">
	<treecols sizable="true">
		<treecol label="Name" />
		<treecol label="Description" />
	</treecols>
	<treechildren>
		<treeitem>
			<treerow>
				<treecell label="Item 1" />
				<treecell label="Item 1 description" />
			</treerow>
		</treeitem>
		<treeitem>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 2.1" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2.1.1" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="Item 2.1.2" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 2.2" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2.2.1" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
			<treerow>
				<treecell label="Item 2" />
				<treecell label="Item 2 description" />
			</treerow>
		</treeitem>
		<treeitem label="Item 3" />
	</treechildren>
</tree>
<zscript>
boolean b = true;
</zscript>
<button label="disabled">
	<attribute name="onClick"><![CDATA[
	                                   
Treeitem selectItem = tree.getSelectedItem();
Collection c=tree.getItems();
Iterator ir=c.iterator();
while(ir.hasNext()){
	Treeitem ti=(Treeitem)ir.next();

	if(selectItem!=null&&!selectItem.equals(ti)) {
		ti.setDisabled(b);
	}
}
b = !b;
	]]></attribute>
</button>
</zk>`,
	);
	await t
		.click(Selector(() => jq('@treecell[label="Item 2.1"]')[0]))
		.click(Selector(() => jq("@button")[0]));
	await t
		.expect(
			await ClientFunction(() => !!jq('@treecell[label="Item 2"]')[0])(),
		)
		.ok();
	await t.click(Selector(() => jq("@button")[0]));
	await t
		.expect(
			await ClientFunction(() => !!jq('@treecell[label="Item 2"]')[0])(),
		)
		.ok();
});

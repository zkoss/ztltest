import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2887722TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2887722TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please check the dot in the tree displays correctly. (Item 2.2 should not connect to Item 3)
<tree id="tree" width="400px" rows="8" zclass="z-dottree">
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
			<treerow>
				<treecell label="Item 2" />
				<treecell label="Item 2 description" />
			</treerow>
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
		</treeitem>
		<treeitem label="Item 3" />
	</treechildren>
</tree>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq('@treecell[label="Item 3"]').children().length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});

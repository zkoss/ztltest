import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3340841TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3340841TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				The first Listitem/Treeitem should be selected (and the checkmark should be checked).
				<listbox id="listbox" multiple="true" checkmark="true" width="200px"
					sclass="readonly-listbox">
					<listhead>
						<listheader>Population</listheader>
					</listhead>
					<listitem selected="true" disabled="true">
						<listcell>A. Graduate</listcell>
					</listitem>
					<listitem disabled="true">
						<listcell>B. College</listcell>
					</listitem>
				</listbox>
				<tree id="tree" multiple="true" checkmark="true" width="200px">
					<treecols>
						<treecol>Population</treecol>
					</treecols>
					<treechildren>
						<treeitem selected="true" disabled="true">
							<treerow>
								<treecell>A. Graduate</treecell>
							</treerow>
						</treeitem>
						<treeitem disabled="true">
							<treerow>
								<treecell>B. College</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listitem:eq(0)").hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-treerow:eq(0)").hasClass("z-treerow-selected"),
			)(),
		)
		.ok();
});

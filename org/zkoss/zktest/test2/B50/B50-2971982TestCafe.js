import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2971982TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2971982TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Check "Second footer" is in third column
				<hbox>
					<listbox id="listbox" width="300px">
						<listhead>
							<listheader label="First" />
							<listheader label="Second" />
							<listheader label="Third" />
						</listhead>
						<listitem>
							<listcell label="test1" />
							<listcell label="test2" />
							<listcell label="test3" />
						</listitem>
						<listfoot>
							<listfooter span="2" label="2 span footer" />
							<listfooter label="Second footer" />
						</listfoot>
					</listbox>
					<separator />
					<tree id="tree" width="300px">
						<treecols>
							<treecol label="First" />
							<treecol label="Second" />
							<treecol label="Third" />
						</treecols>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="test1" />
									<treecell label="test2" />
									<treecell label="test3" />
								</treerow>
							</treeitem>
						</treechildren>
						<treefoot>
							<treefooter span="2" label="2 span footer" />
							<treefooter label="Second footer" />
						</treefoot>
					</tree>
				</hbox>
			</zk>`,
	);
	let listfootleft_cafe = await ClientFunction(
		() => jq(".z-listfooter:contains(Second)").offset().left,
	)();
	let listcellleft_cafe = await ClientFunction(
		() => jq(".z-listcell:contains(test3)").offset().left,
	)();
	let treefootleft_cafe = await ClientFunction(
		() => jq(".z-treefooter:contains(Second)").offset().left,
	)();
	let treecellleft_cafe = await ClientFunction(
		() => jq(".z-treecell:contains(test3)").offset().left,
	)();
	await t
		.expect(
			listfootleft_cafe == listcellleft_cafe &&
				treefootleft_cafe == treecellleft_cafe,
		)
		.ok("Check 'Second footer' is in third column");
});

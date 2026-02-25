import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3314143TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3314143TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Open the Treeitem. The dotted line should rendered correctly (NOT T shape).
				<tree id="tree" zclass="z-dottree">
					<treechildren>
						<treeitem label="Item" open="false">
							<treechildren>
								<treeitem label="Child Item" />
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("open")));
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-treerow:contains(Child)")[0])(),
		)
		.ok();
});

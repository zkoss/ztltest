import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2904577TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2904577TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<zscript><![CDATA[
			void addTreeItem(Treerow tr) {
			Treeitem item = (Treeitem) tr.getParent();
			if (item.getTreechildren()==null) {
			Treechildren tc = new Treechildren();
			for (int i = 0; i < 5; i++) {
			tc.appendChild(getTreeItem(i));
			}
			item.appendChild(tc);
			}
			}
			
			public getTreeItem(int i) {
			Treeitem ti = new Treeitem();
			Treerow tr = new Treerow();
			tr.appendChild(new Treecell("Item " + i));
			tr.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event arg0) throws Exception {
			Treerow row = (Treerow) arg0.getTarget();
			addTreeItem(row);
			}
			});
			ti.appendChild(tr);
			ti.setOpen(true);
			return ti;
			}
			
			]]></zscript>
			
			<tree id="tree" width="400px" rows="8">
				<treecols sizable="true">
					<treecol label="Name" />
				</treecols>
				<treechildren>
					<treeitem>
						<treerow>
							<attribute name="onClick">
									addTreeItem(self);
							</attribute>
							<treecell label="Please Click Me, you should see 5 items added below." />
						</treerow>
					</treeitem>
				</treechildren>
			</tree>
			</zk>`,
	);
	let before_cafe = await ClientFunction(() => jq(".z-treerow").length)();
	await t.click(
		Selector(() => jq(".z-treecell")[0]),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let after_cafe = await ClientFunction(() => jq(".z-treerow").length)();
	await t
		.expect(ztl.normalizeText(after_cafe - before_cafe))
		.eql(ztl.normalizeText("5"));
});

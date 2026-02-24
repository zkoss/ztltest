import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2991309TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2991309TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			1. Click the cell in the tree,
			<tree id="tree" width="500px">
				<treechildren>
					<treeitem id="item">
						<treerow>
							<treecell label="cell" />
						</treerow>
					</treeitem>
				</treechildren>
			</tree> 
			<separator/>
			2. Click this
			<button id="btn" label="Invalidate">
				<attribute name="onClick">
					item.invalidate();
					String function =  	"					function compareSelectedItem (treeUuid, itemUuid, msgUuid) {"
										+ "						var tree = zk.Widget.$(treeUuid),"
										+ "							selectedItem = tree.getSelectedItem(),"
										+ "							itemUuid = zk.Widget.$(itemUuid);"
										+ "						if (selectedItem.$oid != itemUuid.$oid) {"
										+ "							zk.Widget.$(msgUuid).setValue(\\"Wrong: Treeitem and selected item are not the same\\");"
										+ "						}"
										+ "					}";
					Clients.evalJavaScript(function + " compareSelectedItem(\'" + tree.getUuid() + 
					"\', \'" + item.getUuid() + 
					"\', \'" + msg.getUuid() + "\');");
				</attribute>
			</button>
			<separator/>
			3. Check if has error message:
			<label id="msg" style="color: red;" ></label>
			
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("item", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("msg", true).getValue(),
				)(),
			),
		);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2713338TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2713338TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Select any tree item at the tree then click the button,
			
				the button should show "Not Null", if "Null" the it\'s a BUG.
				<zscript>
				    import org.zkoss.zktest.test2.tree.BinaryTreeModel;
				    import java.util.*;
				    BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
				</zscript>
					<tree id="tree" model="&#36;{btm}" />
					<button label="Test">
						<attribute name="onClick">
						    if (tree.getSelectedItem().getValue() == null) {
						        self.label = "Null";
						    } else {
						        self.label = "Not Null";
						    }
						</attribute>
					</button>
			</zk>`,
	);
	await t.click(
		Selector(() => jq("@treecell")[0]),
		{ offsetX: 50, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@button").html())(),
			),
		)
		.eql(ztl.normalizeText("Not Null"));
});

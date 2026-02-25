import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1480TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1480TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <zscript><![CDATA[
		import java.util.ArrayList;
		import org.zkoss.zul.DefaultTreeModel;
		import org.zkoss.zul.DefaultTreeNode;
		
		ArrayList children = new ArrayList();
		children.add(new DefaultTreeNode("Child1"));
		children.add(new DefaultTreeNode("Child2"));
		DefaultTreeNode root = new DefaultTreeNode("Root", children);
		DefaultTreeModel model = new DefaultTreeModel(root);
		void remove() {
			root.remove(1);
		}
	]]></zscript>
                    <window title="title" border="normal">
                      Click "Remove Child2" button directly without open the Bandbox, should not see JS error message.<separator/>
                      <bandbox id="bd" mold="rounded">
                        <bandpopup>
                          <tree id="tree" width="300px" model="\${model}"/>
                        </bandpopup>
                      </bandbox>
                      <button id="removeChild2" label="Remove Child2" onClick="remove()"/>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see any error message.");
});

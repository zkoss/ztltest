import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2947988TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2947988TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			
			    <zscript><![CDATA[
			        java.util.ArrayList children = new java.util.ArrayList();
			        children.add(new DefaultTreeNode("1", new java.util.ArrayList()));
			       DefaultTreeModel model = new DefaultTreeModel(new DefaultTreeNode("ROOT",children));
			
			        void removeItem () {
						testTree.setModel(null);
			        }
			    ]]></zscript>
			    <tree id="testTree" model="\${model}"/>
			    <button id="add" label="Click me shouldn\'t have any error." onClick="removeItem()"/>
			
			
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("add", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

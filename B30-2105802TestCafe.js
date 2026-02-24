import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2105802TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2105802TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Trees" border="normal">
When you click the "Add/Remove Child" button, and then the treeitem\'s icon should disappear. 
<tree id="tree" width="90%" rows="5">
<treecols sizable="true">
<treecol label="Name"/>
<treecol label="Description"/>
</treecols>
<treechildren>
<treeitem id="ti">
<treerow id="tr">
<treecell label="Item 1"/>
<treecell label="Item 1 description"/>
</treerow>
</treeitem>
</treechildren>
</tree>
<button onClick="addRemove()" label="Add/Remove Child"/>
<zscript>
addRemove() {
tc2=new Treechildren();
tc2.parent=ti;
Messagebox.show("Added..., and you should see the arrow icon on the treeitem.", null, Messagebox.OK, Messagebox.INFORMATION, 0, new EventListener() {
public void onEvent(Event event) throws Exception {
tc2.detach();
alert("Removed..., and you shouldn\'t see the arrow icon");
}
});

}
</zscript>
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-tree-icon")[0])()).ok();
	await t.click(Selector(() => jq('@window[title="ZK Test"] @button')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-tree-icon")[0])())
		.notOk();
});

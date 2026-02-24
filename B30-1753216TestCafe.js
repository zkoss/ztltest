import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1753216TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1753216TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
		If no error occur, it is right.
		<tree mold="paging" pageSize="3">
			<treechildren>
				<treeitem id="ti0" selected="true" onOpen="onOpen(event, 4)" open="false">
					<treerow>
						<treecell label="Add onOpen"/>
					</treerow>
					<treechildren id="tch">
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>
		<zscript><![CDATA[
		void onOpen(Event evt, int cnt) {
			if (evt.open) {
				for (int j = 1; j <= cnt; ++j) {
					Treeitem ti = new Treeitem();
					Treerow tr = new Treerow();
					new Treecell("new " + j).setParent(tr);
					tr.setParent(ti);
					ti.setParent(tch);
				}
		
			}
		}
		]]></zscript>
		</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("ti0", true).$n("open")));
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

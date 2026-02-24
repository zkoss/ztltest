import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-480TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-480TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Open the Treeitem. You should NOT see javascript error.</div>
				<tree id="tree">
					<treechildren>
						<treeitem id="ti" label="Item 1" open="false">
							<treechildren>
								<treeitem draggable="true" label="Item 2" />
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

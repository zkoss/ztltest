import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2993604TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2993604TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<button id="btn" label="change label" onClick=\'treecell.label="new Name"\' />
				<tree>
					<treechildren>
						<treeitem>
							<treerow id="treerow">
								<treecell label="Item" id="treecell" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="Item 1" />
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("treerow", true).$n("open")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("treerow", true).$n("open")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("treerow", true).$n("icon")).is(
					"[class*=down]",
				),
			)(),
		)
		.ok();
});

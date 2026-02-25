import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3006762TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3006762TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<tree id="tree" multiple="true">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="1" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="1.1" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="1.1.1" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell label="1.1.2" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell label="1.1.3" />
											</treerow>
										</treeitem>
									</treechildren>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t
		.click(Selector(() => jq('@treecell[label="1.1.1"]')[0]))
		.click(Selector(() => zk.Widget.$(jq("@treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("tree", true).$n().firstChild
							.clientHeight,
				)(),
			),
		),
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("tree", true).$n().firstChild
							.scrollHeight,
				)(),
			),
		),
		ztl.normalizeText("1"),
	);
});

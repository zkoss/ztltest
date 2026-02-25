import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2780144TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2780144TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				You should see the both tree are the same display.
				<tree zclass="z-dottree">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="a" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="b" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="c" id="treecell1"/>
											</treerow>
										</treeitem>
										<treeitem visible="false">
												<treerow>
													<treecell label="d" />
												</treerow>
										</treeitem>
									</treechildren>
								</treeitem>
								<treeitem   visible="false" >
									<treerow>
										<treecell label="e"/>
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
				<tree zclass="z-dottree" id="tree2">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="a" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="b" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="c" id="treecell2"/>
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
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("treecell2", true))
						.find("span:eq(1)")
						.attr("class"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("treecell1", true))
						.find("span:eq(1)")
						.attr("class"),
				)(),
			),
		);
});

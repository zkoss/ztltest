import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3085855TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3085855TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>If you see Item 2 in the tree, it is a bug.</li>
		</ol>
	]]></html>
	<tree width="400px">
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
				</treerow>
			</treeitem>
			<treeitem visible="false">
				<treerow>
					<treecell />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell style="color: red" label="Item 2 (Bug!)" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
		</treechildren>
	</tree>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-treerow:contains(Item 2)")[0],
			)(),
		)
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 1"), "");
});

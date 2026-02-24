import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1822643TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1822643TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
When current page is last page, call setPageSize method.
Notice: This only happens when the change pageSize is larger than current
pageSize

	<button id="btn" label="Set PageSize">
			<attribute name="onClick">
				tree.setPageSize(10);
			</attribute>
		</button>
	<tree id="tree" mold="paging" width="90%" pageSize="2">
		<treechildren>
			<treeitem label="Item 1" />
			<treeitem label="Item 2" />
			<treeitem label="Item 3" />
			<treeitem label="Item 4" />
			<treeitem label="Item 5" />
			<treeitem label="Item 6" />
			<treeitem label="Item 7" />
			<treeitem label="Item 8" />
			<treeitem label="Item 9" />
			<treeitem label="Item 10" />
			<treeitem label="Item 11" />
			<treeitem label="Item 12" />
			<treeitem label="Item 13" />
			<treeitem label="Item 14" />
			<treeitem label="Item 15">
				<treechildren>
			<treeitem label="Item 15.1" />
			<treeitem label="Item 15.2" />
			<treeitem label="Item 15.3" />
			<treeitem label="Item 15.4" />
			<treeitem label="Item 15.5" />
			<treeitem label="Item 15.6" />
			<treeitem label="Item 15.7" />
			<treeitem label="Item 15.8" />
			<treeitem label="Item 15.9" />
			<treeitem label="Item 15.10" />
			<treeitem label="Item 15.11" />
			<treeitem label="Item 15.12" />
			<treeitem label="Item 15.13" />
			<treeitem label="Item 15.14" />
			<treeitem label="Item 15.15" />
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
					jq(".z-paging-info > span:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("[ 1 - 2 / 30 ]"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treechildren tr").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-paging-info > span:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("[ 1 - 10 / 30 ]"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treechildren tr").length)(),
			),
		)
		.eql(ztl.normalizeText("10"));
});

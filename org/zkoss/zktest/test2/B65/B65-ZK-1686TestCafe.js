import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1686TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1686TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click next page button, should not see js error.
	<window>
		<tree mold="paging" pageSize="3">
			<treecols>
				<treecol label="Test" />
				<treecol label="Test" />
				<treecol label="Test" />
				<treecol label="Test" />
			</treecols>
			<treechildren>
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
			</treechildren>
		</tree>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should not see js error.");
});

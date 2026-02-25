import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-3985TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-3985.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-3985TestCafe", async (t) => {
	await ztl.initTest(t);
	let listboxHeight_cafe = await ClientFunction(() =>
		jq(".z-listbox").height(),
	)();
	await t.click(Selector(() => jq(".z-listcell").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText(listboxHeight_cafe + ""), "");
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	let gridHeight_cafe = await ClientFunction(() => jq(".z-grid").height())();
	await t.click(Selector(() => jq(".z-cell").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText(gridHeight_cafe + ""), "");
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	let treeHeight_cafe = await ClientFunction(() => jq(".z-tree").height())();
	await t.click(Selector(() => jq(".z-treecell").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText(treeHeight_cafe + ""), "");
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
});

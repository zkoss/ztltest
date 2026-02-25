import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F85-ZK-3835TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3835.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3835TestCafe", async (t) => {
	await ztl.initTest(t);
	let contentH1_cafe = await ClientFunction(
		() => jq("@tree .z-tree-body")[0].scrollHeight,
	)();
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:eq(0)")).$n("open")),
	);
	await ztl.waitResponse(t);
	let contentH2_cafe = await ClientFunction(
		() => jq("@tree .z-tree-body")[0].scrollHeight,
	)();
	await t
		.expect(contentH2_cafe > contentH1_cafe)
		.ok("When opened node, the height should be bigger");
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		dist: contentH2_cafe,
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:last")).$n("open")),
	);
	await ztl.waitResponse(t);
	let contentH3_cafe = await ClientFunction(
		() => jq("@tree .z-tree-body")[0].scrollHeight,
	)();
	await t
		.expect(contentH3_cafe > contentH2_cafe)
		.ok("When opened node, the height should be bigger");
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:eq(0)")).$n("open")),
	);
	await ztl.waitResponse(t);
	let contentH4_cafe = await ClientFunction(
		() => jq("@tree .z-tree-body")[0].scrollHeight,
	)();
	await t
		.expect(ztl.normalizeText(contentH2_cafe))
		.eql(
			ztl.normalizeText(contentH4_cafe),
			"When closed node, the height should remain",
		);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2589TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2589.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2589TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		percent: "10.0",
	});
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow .z-tree-icon").eq(7)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow .z-tree-icon").eq(7)[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-treerow").last().is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow")
						.last()
						.find(".z-label")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("test-60"));
});

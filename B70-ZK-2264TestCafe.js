import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2264TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2264.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2264TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await ClientFunction(() => {
		zk.Widget.$(jq("@grid"))._scrollbar._mouseEnter();
	})();
	let actionVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-scrollbar-indicator").width(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_0_0 + ",2",
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr("100,2");

	await t.drag(
		Selector(() => jq(".z-scrollbar-indicator")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@grid"))._scrollbar._mouseEnter();
	})();
	let actionVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-scrollbar-indicator").width(),
	)();
	let cafeCoord_3 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_1_1 + ",2",
	);

	let cafeCoord_4 = await ztl.convertCoordStrToArr("2,2");

	await t.drag(
		Selector(() => jq(".z-scrollbar-indicator")[0]),
		cafeCoord_3[0] - cafeCoord_4[0],
		cafeCoord_3[1] - cafeCoord_4[1],
		{ offsetX: cafeCoord_4[0], offsetY: cafeCoord_4[1] },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_2 = await ClientFunction(() =>
		jq("@column").eq(1).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_2 < 1)
		.ok("The width of column eqauls -1 means grid can be scrolled.");
});

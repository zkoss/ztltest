import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-4219TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4219.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4219TestCafe", async (t) => {
	await ztl.initTest(t);
	let clickPosition_cafe_0 = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let clickPosition_cafe_1 = await ClientFunction(
		() => jq(".z-column").eq(1).offset().top,
	)();
	let clickPosition_cafe_2 = await ClientFunction(
		() => jq(".z-column").eq(1).offset().left,
	)();
	let clickPosition_cafe =
		clickPosition_cafe_2 +
		clickPosition_cafe_0 -
		1 +
		"," +
		(clickPosition_cafe_1 + 1);
	let cafeCoord_1 = await ztl.convertCoordStrToArr(clickPosition_cafe);

	await t.doubleClick(
		Selector(() => jq(".z-column").eq(1)[0]),
		{ offsetX: cafeCoord_1[0], offsetY: cafeCoord_1[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2438TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2438.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2438TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-detail")[0]));
	await ztl.waitResponse(t);
	let startL_cafe = await ClientFunction(
		() => jq(".z-slider-button").last().position().left,
	)();
	let startT_cafe = await ClientFunction(
		() => jq(".z-slider-button").last().position().top,
	)();
	let endL_cafe = startL_cafe + 60;
	await t.hover(Selector(() => jq(".z-slider-button").last()[0]));
	await ztl.waitResponse(t);
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		endL_cafe + "," + startT_cafe,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	await t.drag(
		Selector(() => jq(".z-slider-button").last()[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell>.z-label").last().text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});

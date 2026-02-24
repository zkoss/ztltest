import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2496TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2496.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2496TestCafe", async (t) => {
	await ztl.initTest(t);
	let wnx_cafe = await ClientFunction(() => jq("@panel").position().left)();
	let wny_cafe = await ClientFunction(() => jq("@panel").position().top)();
	let actionVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@panel").outerHeight(),
	)();
	let actionVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@panel").outerHeight(),
	)();
	let actionVariable_cafe_2_2 = await ClientFunction(() =>
		jq("@panel").outerWidth(),
	)();
	let actionVariable_cafe_3_3 = await ClientFunction(() =>
		jq("@panel").outerWidth(),
	)();
	let actionVariable_cafe_4_4 = await ClientFunction(() =>
		jq("@panel").outerHeight(),
	)();
	let actionVariable_cafe_5_5 = await ClientFunction(() =>
		jq("@panel").outerHeight(),
	)();
	let actionVariable_cafe_6_6 = await ClientFunction(() =>
		jq("@panel").outerWidth(),
	)();
	let actionVariable_cafe_7_7 = await ClientFunction(() =>
		jq("@panel").outerWidth(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_6_6 + 20 + "," + (actionVariable_cafe_4_4 + 20),
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_2_2 - 2 + "," + (actionVariable_cafe_0_0 - 2),
		true,
	);

	await t.drag(
		Selector(() => jq("@panel")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").position().left)(),
			),
		)
		.eql(ztl.normalizeText(wnx_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").position().top)(),
			),
		)
		.eql(ztl.normalizeText(wny_cafe));
});

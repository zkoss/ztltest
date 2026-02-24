import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3768-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B85-ZK-3768-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B85-ZK-3768.zul"/>`);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let width0_cafe = await ClientFunction(() =>
		jq("@listheader:eq(1)").outerWidth(),
	)();
	let height0_cafe = await ClientFunction(() =>
		jq("@listheader:eq(1)").outerHeight(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		width0_cafe + "," + height0_cafe / 2,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		width0_cafe - 2 + "," + height0_cafe / 2,
		true,
	);

	await t.drag(
		Selector(() => jq("@listheader:eq(1)")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("150"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listheader:eq(0)").width())(),
			),
		);
});

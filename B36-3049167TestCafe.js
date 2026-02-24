import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-3049167TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-3049167.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-3049167TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let pos_cafe_0 = await ClientFunction(
		() => jq(".z-listbox-body .z-listcell:eq(2)").position().left,
	)();
	let pos_cafe_1 = await ClientFunction(
		() => jq(".z-listbox-body .z-listcell:eq(2)").position().top,
	)();
	let pos_cafe = pos_cafe_0 + "," + pos_cafe_1;
	let cafeCoord_1 = await ztl.convertCoordStrToArr(pos_cafe);

	await t.drag(
		Selector(() => jq(".z-listbox-body .z-listcell:eq(0)")[0]),
		cafeCoord_1[0],
		cafeCoord_1[1],
	);
	await ztl.waitResponse(t);
	let infotxt_cafe = await ClientFunction(() =>
		jq(jq(".z-listbox .z-paging-info > span:eq(0)"))
			.text()
			.replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("[ 1 - 5 / 8 ]"))
		.eql(ztl.normalizeText(infotxt_cafe));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let cafeCoord_2 = await ztl.convertCoordStrToArr(pos_cafe);

	await t.drag(
		Selector(() => jq(".z-grid .z-label:eq(0)")[0]),
		cafeCoord_2[0],
		cafeCoord_2[1],
	);
	await ztl.waitResponse(t);
	let infotxt1_cafe = await ClientFunction(() =>
		jq(jq(".z-grid .z-paging-info > span:eq(0)"))
			.text()
			.replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("[ 1 - 5 / 8 ]"))
		.eql(ztl.normalizeText(infotxt1_cafe));
});

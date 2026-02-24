import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1914078TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1914078.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1914078TestCafe", async (t) => {
	await ztl.initTest(t);
	let width_cafe_0 = await ClientFunction(() => jq("body").width())();
	let width_cafe = width_cafe_0 / 2;
	let height_cafe_1 = await ClientFunction(() => jq("body").height())();
	let height_cafe = height_cafe_1 / 2;
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let left_cafe = await ClientFunction(() => jq("$win").offset().left)();
	let top_cafe = await ClientFunction(() => jq("$win").offset().top)();
	await t.expect(top_cafe > 100).ok();
	await t.expect(top_cafe < height_cafe).ok();
	await t.expect(left_cafe > 100).ok();
	await t.expect(left_cafe < width_cafe).ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let left_cafet = await ClientFunction(() => jq("$win").offset().left)();
	let top_cafet = await ClientFunction(() => jq("$win").offset().top)();
	await t.expect(top_cafet > 100).ok();
	await t.expect(top_cafet < height_cafe).ok();
	await t.expect(left_cafet > 100).ok();
	await t.expect(left_cafet < width_cafe).ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let left_cafett = await ClientFunction(() => jq("$win").offset().left)();
	let top_cafett = await ClientFunction(() => jq("$win").offset().top)();
	await t.expect(top_cafett > 100).ok();
	await t.expect(top_cafett < height_cafe).ok();
	await t.expect(left_cafett > 100).ok();
	await t.expect(left_cafett < width_cafe).ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2799258TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2799258.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2799258TestCafe", async (t) => {
	await ztl.initTest(t);
	let x_cafe = await ClientFunction(() =>
		jq("@listheader:eq(0)").outerWidth(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(x_cafe + 500 + ",0");

	let cafeCoord_2 = await ztl.convertCoordStrToArr(x_cafe + ",0", true);

	await t.drag(
		Selector(() => jq("@listheader:eq(0)")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	let bodyHeight_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@listbox")).$n("body")).innerHeight(),
	)();
	let caveHeight_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@listbox")).$n("body"))
			.find("table")
			.outerHeight(),
	)();
	await t.expect(bodyHeight_cafe >= caveHeight_cafe).ok();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3600TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3600.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3600TestCafe", async (t) => {
	await ztl.initTest(t);
	let gridHeight_cafe = await ClientFunction(
		() => jq("@grid:eq(0) .z-grid-body")[0].scrollHeight,
	)();
	let listboxHeight_cafe = await ClientFunction(
		() => jq("@listbox:eq(0) .z-listbox-body")[0].scrollHeight,
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let gridHeight2_cafe = await ClientFunction(
		() => jq("@grid:eq(0) .z-grid-body")[0].scrollHeight,
	)();
	let listboxHeight2_cafe = await ClientFunction(
		() => jq("@listbox:eq(0) .z-listbox-body")[0].scrollHeight,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(gridHeight_cafe),
		ztl.normalizeText(gridHeight2_cafe),
		ztl.normalizeText("100"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(listboxHeight_cafe),
		ztl.normalizeText(listboxHeight2_cafe),
		ztl.normalizeText("100"),
	);
});

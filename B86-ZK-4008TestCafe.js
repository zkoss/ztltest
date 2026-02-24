import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-4008TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4008.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4008TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:contains(append)")[0]));
	await ztl.waitResponse(t);
	let widthCell_cafe = await ClientFunction(() =>
		jq("@row > td:last .z-row-content").width(),
	)();
	await t.click(Selector(() => jq("@button:contains(invalidate)")[0]));
	await ztl.waitResponse(t);
	let widthCellInvalidated_cafe = await ClientFunction(() =>
		jq("@row > td:last .z-row-content").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(widthCell_cafe),
		ztl.normalizeText(widthCellInvalidated_cafe),
		ztl.normalizeText("2"),
	);
});

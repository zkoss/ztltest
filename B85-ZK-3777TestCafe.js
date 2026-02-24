import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3777TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3777.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3777TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq(".z-slider-button")[0]),
		0,
		95,
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("Test"), "Zklog should contain 'Test'.");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F85-ZK-3778TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3778.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3778TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq(".z-slider-button:eq(0)")[0]),
		0,
		99,
		{ offsetX: 5, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-slider-button:eq(1)")[0]),
		0,
		99,
		{ offsetX: 5, offsetY: 1 },
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
		.eql(ztl.normalizeText("false\ntrue"));
});

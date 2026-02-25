import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F85-ZK-3315-cometTestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3315-comet.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3315-cometTestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq("@textbox"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox")[0]),
		ztl.normalizeText("ZTL Test"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@textbox")[0])).pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("[SP] injected."),
			"Injected text should be printed if hook is successful",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("[SP] success"),
			"Injected text should be printed if hook is successful",
		);
});

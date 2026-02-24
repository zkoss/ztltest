import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1205TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1205.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1205TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(click me)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.ok("should exist");
	await t
		.expect(ztl.normalizeText("hidden"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-notification").css("visibility"),
				)(),
			),
			"displays a notification message",
		);
	await t.wait(2000);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok(
			"The message should not disappear immediately after it opened. Otherwise, it is an error.",
		);
	await t.click(Selector(() => jq(".z-panel")[0]));
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.notOk("The message should only close upon mouse click.");
});

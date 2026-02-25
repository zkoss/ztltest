import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2990TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2990.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2990TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq(".z-button:contains(Show notification!)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-window-close")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-notification").find(".z-notification-close")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.notOk();
});

//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4204TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4204.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4204TestCafe", async (t) => {
	await ztl.initTest(t);
	// Reload via navigateTo, not t.eval(() => location.reload()): an in-page
	// reload aborts the proxy socket carrying the eval result, which WebKit
	// surfaces as an "aborted/abortIncoming" unhandled rejection.
	const pageUrl = "./B86-ZK-4204.zul";
	await t.navigateTo(pageUrl);
	await t.wait(2000);
	await t.navigateTo(pageUrl);
	await t.wait(10000);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$rmDesktopIndicator").html())(),
			),
		)
		.notEql(ztl.normalizeText(""), "rmDesktop not received.");
});

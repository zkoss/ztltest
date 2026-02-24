//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
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
	await t.eval(() => location.reload(true));
	await t.wait(2000);
	await t.eval(() => location.reload(true));
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

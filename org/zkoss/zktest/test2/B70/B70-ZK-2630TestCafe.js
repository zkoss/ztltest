import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2630TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2630.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2630TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-window-close").offset().top)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-caption-content").offset().top)(),
		),
		ztl.normalizeText("1"),
	);
});

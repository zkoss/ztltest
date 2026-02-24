import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1567TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1567.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1567TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-menu:contains(More)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-menu").offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-menupopup").offset().left)(),
		),
		ztl.normalizeText("3"),
	);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B95-ZK-4665TestCafe`
	.page`http://localhost:8080/zktest/test2/B95-ZK-4665.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B95-ZK-4665TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,safari,ie11,ie10,ie9,edge")) {
		console.log(
			"This issue is ignored in current browser! (chrome,safari,ie11,ie10,ie9,edge)",
		);
		return;
	}
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$cRig").offset().top)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$cMid").offset().top)(),
			),
		);
});

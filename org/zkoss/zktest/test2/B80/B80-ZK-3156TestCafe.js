import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3156TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3156.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3156TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,ie11,ie10,ie9")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,ie11,ie10,ie9)",
		);
		return;
	}
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-label:eq(1)").text().length > 6,
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});

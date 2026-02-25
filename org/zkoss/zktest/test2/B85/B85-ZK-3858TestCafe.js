import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3858TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3858.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3858TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-center-body > div").width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-north-body > div").width())(),
			),
		);
});

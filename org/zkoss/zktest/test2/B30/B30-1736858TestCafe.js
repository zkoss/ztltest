import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1736858TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1736858.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1736858TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000).click(Selector(() => jq("@button")[0]));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						":contains(The resource you request is no longer available)",
					)[0],
			)(),
		)
		.ok();
});

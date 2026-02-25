import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1729253TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1729253.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1729253TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq('@window[title="My First window"]')[0],
			)(),
		)
		.ok();
});

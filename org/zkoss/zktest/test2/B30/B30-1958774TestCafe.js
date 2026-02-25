import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1958774TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1958774.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1958774TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(() => !!jq('@window[title="tree demo"]')[0])(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(
				() => !!jq('@window:not(@window[title="tree demo"])')[0],
			)(),
		)
		.notOk();
});

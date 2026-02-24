import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3578TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3578.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3578TestCafe", async (t) => {
	await ztl.initTest(t);
	let len_cafe = await ClientFunction(
		() => jq(".z-columns:visible:eq(0)").children().length,
	)();
	await t.click(Selector(() => jq("$toggle")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$toggle")[0]));
	await ztl.waitResponse(t);
	let lenAfter_cafe = await ClientFunction(
		() => jq(".z-columns:visible:eq(0)").children().length,
	)();
	await t
		.expect(ztl.normalizeText(lenAfter_cafe))
		.eql(
			ztl.normalizeText(len_cafe),
			"The number of columns should be the same",
		);
});

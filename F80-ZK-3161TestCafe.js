import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F80-ZK-3161TestCafe`
	.page`http://localhost:8080/zktest/test2/F80-ZK-3161.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F80-ZK-3161TestCafe", async (t) => {
	await ztl.initTest(t);
	let tt_cafe = await ClientFunction(
		() => jq(".z-west-collapsed")[0].title,
	)();
	await t
		.expect(ztl.normalizeText(tt_cafe))
		.eql(ztl.normalizeText("west title"));
	tt_cafe = await ClientFunction(() => jq(".z-north-collapsed")[0].title)();
	await t.expect(ztl.normalizeText(tt_cafe)).eql(ztl.normalizeText(""));
});

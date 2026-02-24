import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3207TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3207.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3207TestCafe", async (t) => {
	await ztl.initTest(t);
	let h_cafe = await ClientFunction(
		() => jq(".z-groupbox")[0].offsetHeight,
	)();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-groupbox")[0].offsetHeight)(),
			),
		)
		.eql(ztl.normalizeText(h_cafe));
});

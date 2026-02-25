import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3794TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3794.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3794TestCafe", async (t) => {
	await ztl.initTest(t);
	let textVal_cafe = await ClientFunction(() => jq(".z-textbox").val())();
	let labelTxt_cafe = await ClientFunction(() =>
		jq(".z-label:eq(1)").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(labelTxt_cafe))
		.contains(ztl.normalizeText(textVal_cafe), "");
});

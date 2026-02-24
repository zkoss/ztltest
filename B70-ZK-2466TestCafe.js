import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2466TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2466.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2466TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let AAA_cafe = await ClientFunction(() =>
		jq(".z-column-content").first().text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(AAA_cafe)).eql(ztl.normalizeText("AAA"));
});

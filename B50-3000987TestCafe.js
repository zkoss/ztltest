import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3000987TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3000987.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3000987TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@option:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
});

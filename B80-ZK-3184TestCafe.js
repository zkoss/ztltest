import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3184TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3184.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3184TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk(
						'.z-grid .z-label:contains("Target")',
					).isRealScrollIntoView(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});

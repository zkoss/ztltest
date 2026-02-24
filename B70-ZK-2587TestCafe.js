import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2587TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2587.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2587TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => jq(".z-tabpanel .z-label")[0]),
		Selector(() => jq(".z-tab")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tab .z-tab-text").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("dropped: 'in tabbox'"));
});

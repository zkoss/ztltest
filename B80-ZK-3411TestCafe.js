import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3411TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3411.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3411TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-grid").outerHeight())(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-window-content").height())(),
			),
		);
});

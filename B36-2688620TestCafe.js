import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2688620TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2688620.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2688620TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk(jq("@timebox").find("input"))
						.getSelectionRange()
						.toString(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0,2"), "[05] should be selected");
});

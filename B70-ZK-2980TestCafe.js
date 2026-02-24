//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2980TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2980.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2980TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("button:contains(save)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("button:contains(edit)").eq(0).is(":focus"),
			)(),
		)
		.ok();
});

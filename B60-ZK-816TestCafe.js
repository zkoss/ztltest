import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-816TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-816.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-816TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.hover(Selector(() => jq(".z-label:contains(new label):eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-popup:contains(this is tool tip)").eq(0).is(":visible"),
			)(),
		)
		.ok();
	await t.hover(Selector(() => jq(".z-label:contains(new label):eq(3)")[0]));
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-popup:contains(this is tool tip)").eq(1).is(":visible"),
			)(),
		)
		.ok();
});

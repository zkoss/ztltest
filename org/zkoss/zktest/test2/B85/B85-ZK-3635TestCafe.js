//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3635TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3635.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3635TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-textbox").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-bandpopup")[0])()).ok();
	await t
		.expect(
			await ClientFunction(() => jq(".z-textbox").eq(1).is(":focus"))(),
		)
		.ok();
});

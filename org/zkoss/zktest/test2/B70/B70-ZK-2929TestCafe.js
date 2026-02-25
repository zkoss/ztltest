import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2929TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2929.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2929TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.click(Selector(() => jq(".z-combobox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasHScrollbar({
				locator: Selector(() => jq(".z-combobox-popup")[0]),
			}),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-combobox-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasHScrollbar({
				locator: Selector(() => jq(".z-combobox-popup")[0]),
			}),
		)
		.notOk();
});

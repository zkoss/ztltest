import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2841185TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2841185.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2841185TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-paging-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("backspace");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-paging-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-paging-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("2");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-grid").is(":visible"))())
		.ok("The grid should be visible");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1984643TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1984643.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1984643TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t
		.click(Selector(() => jq("@select")[0]))
		.click(Selector(() => jq("option:contains(item 1)")[0]));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@select").is(":visible"))())
		.notOk("The Listbox should be invisible");
});

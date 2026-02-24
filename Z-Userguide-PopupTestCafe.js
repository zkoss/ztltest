import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z-Userguide-PopupTestCafe`
	.page`http://localhost:8080/zktest/test2/Z-Userguide-Popup.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z-Userguide-PopupTestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.hover(Selector(() => jq("@image:eq(0)")[0])).wait(1000);
	await t
		.expect(await ClientFunction(() => jq("$mail").is(":visible"))())
		.ok();
	await t.click(Selector(() => jq("$view").find("@textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$mail").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("@image:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$title").is(":visible"))())
		.ok();
});

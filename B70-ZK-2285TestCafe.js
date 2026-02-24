import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2285TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2285.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2285TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.click(Selector(() => jq(".z-option:contains(test4)")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-option:contains(test4)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-option:contains(test4)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("shift+down");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-option:contains(test5)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-option:contains(test5)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("shift+down");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-option:contains(test6)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-option:contains(test6)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("shift+down");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-option:contains(test7)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-option:contains(test7)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("shift+down");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect("false").ok("4 items in listbox should be selected.");
});

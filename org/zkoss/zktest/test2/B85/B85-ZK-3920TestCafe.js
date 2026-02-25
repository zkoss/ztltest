import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3920TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3920.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3920TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listitem:contains(item 2-5)")[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listgroup-icon")[1]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasVScrollbar({
				locator: Selector(
					() => jq(zk.Widget.$(jq("@listbox")).$n("body"))[0],
				),
			}),
		)
		.notOk();
});

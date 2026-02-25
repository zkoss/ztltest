import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3702TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3702.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3702TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).$n("real").focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-combobox-content").is(":visible"),
			)(),
		)
		.ok();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).$n("real").focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("ctrl");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-combobox-content").is(":visible"),
			)(),
		)
		.notOk();
});

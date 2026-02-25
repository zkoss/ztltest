import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2784TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2784.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2784TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.resizeWindow(1024, 768);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$click1")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$click2")[0]));
	await ztl.waitResponse(t);
	await t.resizeWindow(1024, 760);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-scrollbar-vertical-embed:eq(0)")[0],
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-scrollbar-vertical-embed:eq(1)")[0],
			)(),
		)
		.notOk();
});

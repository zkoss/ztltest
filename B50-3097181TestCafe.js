import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3097181TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3097181.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3097181TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.hover(Selector(() => zk.Widget.$(jq(".z-menu:eq(0)")).$n("a")));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => zk.Widget.$(jq(".z-menu:eq(1)")).$n("a")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-colorpalette")).is(":visible"),
			)(),
		)
		.ok();
	await t.hover(Selector(() => jq(".z-colorpalette-color:eq(8)")[0]));
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-colorpalette")).is(":visible"),
			)(),
		)
		.ok();
	await t.hover(Selector(() => jq(".z-colorpalette-color:eq(18)")[0]));
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-colorpalette")).is(":visible"),
			)(),
		)
		.ok();
	await t.hover(Selector(() => jq(".z-colorpalette-color:eq(28)")[0]));
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-colorpalette")).is(":visible"),
			)(),
		)
		.ok();
});

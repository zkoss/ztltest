import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1979239TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1979239.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1979239TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t
		.hover(Selector(() => zk.Widget.$(jq(".z-menu")).$n("a")))
		.wait(500)
		.hover(Selector(() => jq(".z-menuitem")[0]))
		.wait(2000);
	await t.expect(await ClientFunction(() => !!jq(".z-popup")[0])()).ok();
	await t
		.expect(await ClientFunction(() => jq(".z-popup").is(":visible"))())
		.ok();
});

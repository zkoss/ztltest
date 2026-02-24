import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2254TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2254.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2254TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.wait(5000);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-tree")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-label:contains(c59)")[0])())
		.ok("the 'c59' label should be there.");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B96-ZK-4929TestCafe`
	.page`http://localhost:8080/zktest/test2/B96-ZK-4929.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B96-ZK-4929TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ff,ie11,ie10,ie9,edge_legacy")) {
		console.log(
			"This issue is ignored in current browser! (ff,ie11,ie10,ie9,edge_legacy)",
		);
		return;
	}
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t.wait(1200);
	await t
		.expect(
			await ClientFunction(() => jq(".z-bandbox-popup").is(":visible"))(),
		)
		.ok("bandpopup shall not closed with keyCode 0");
});

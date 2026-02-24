import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B96-ZK-4707TestCafe`
	.page`http://localhost:8080/zktest/test2/B96-ZK-4707.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B96-ZK-4707TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ztl.isBrowserIgnored(
			"chrome,safari,edge_legacy,edge,ie11,ie10,ie9",
		)
	) {
		console.log(
			"This issue is ignored in current browser! (chrome,safari,edge_legacy,edge,ie11,ie10,ie9)",
		);
		return;
	}
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$tb")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$item")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-menupopup").is(":visible"))())
		.ok("2nd popup should be visible");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-587TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-587.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-587TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,edge_legacy,ie11,ie10")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,edge_legacy,ie11,ie10)",
		);
		return;
	}
	await ztl.doScroll({
		locator: Selector(() => jq(".z-listbox-body")[0]),
		scrollType: "vertical",
		percent: "110.0",
	});
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => !!jq(".z-listcell:contains(Option 249999)")[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});

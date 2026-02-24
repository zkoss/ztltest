import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-700TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-700.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-700TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,edge_legacy,ie11,ie10")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,edge_legacy,ie11,ie10)",
		);
		return;
	}
	await t.click(Selector(() => jq("$div")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("100 + 100 + 100 = 300\n100 + 100 + 100 = 300"));
});

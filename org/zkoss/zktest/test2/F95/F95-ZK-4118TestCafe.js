import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F95-ZK-4118TestCafe`
	.page`http://localhost:8080/zktest/test2/F95-ZK-4118.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F95-ZK-4118TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ztl.isBrowserIgnored("chrome,ff,safari,ie11,ie10,ie9,edge_legacy")
	) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,ie11,ie10,ie9,edge_legacy)",
		);
		return;
	}
	await ztl.waitResponse(t);
	let log_cafe = await ClientFunction(() =>
		jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
	)();
	await t
		.expect(ztl.normalizeText(log_cafe))
		.notContains(ztl.normalizeText("zk.edge: false"), "");
	await t
		.expect(ztl.normalizeText(log_cafe))
		.contains(ztl.normalizeText("zk.edge_legacy: false"), "");
	let resultLabel_cafe = await ClientFunction(() => jq("$result").html())();
	await t
		.expect(ztl.normalizeText(resultLabel_cafe.trim()))
		.notContains(ztl.normalizeText("edge: , edge_legacy:"), "");
	await t
		.expect(ztl.normalizeText(resultLabel_cafe.trim()))
		.notContains(ztl.normalizeText("edge_legacy: "), "");
});

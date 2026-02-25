import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F65-ZK-2012TestCafe`
	.page`http://localhost:8080/zktest/test2/F65-ZK-2012.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F65-ZK-2012TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,edge_legacy,ie10,ie9")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,edge_legacy,ie10,ie9)",
		);
		return;
	}
	let log_cafe = await ClientFunction(() => jq("#zk_log").val())();
	await t
		.expect(ztl.normalizeText(log_cafe))
		.contains(
			ztl.normalizeText("zk.ie: 11"),
			"should see 'zk.ie: 11, zk.ff: false' in zk.log",
		);
	await t
		.expect(ztl.normalizeText(log_cafe))
		.contains(
			ztl.normalizeText("zk.ff: false"),
			"should see 'zk.ie: 11, zk.ff: false' in zk.log",
		);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.expect("false").ok();
	await t.expect("false").ok();
	await t.expect("false").ok();
	await t.expect("false").ok();
	await t.expect("false").ok();
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(
				".z-vlayout:eq(1) .z-label:contains({version=11.0, name=ie}), .z-vlayout:eq(1) .z-label:contains({name=ie, version=11.0})",
			)[0],
	)();
	await t.expect(verifyVariable_cafe_0_0).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-vlayout:eq(1) .z-label:contains(11)").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 == 2).ok();
});

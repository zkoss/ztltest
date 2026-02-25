import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2690TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2690.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2690TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq("@grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "300.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-auxheader").eq(1).width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 < 1).ok();
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq("@grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "-300.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-auxheader").eq(1).width(),
	)();
	await t.expect(verifyVariable_cafe_1_1 > 1).ok();
});

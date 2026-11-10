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
	const auxheaderWidth = ClientFunction(() =>
		jq(".z-auxheader").eq(1).width(),
	);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq("@grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "300.0";
	})();
	await t.expect(auxheaderWidth()).lt(1);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq("@grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "-300.0";
	})();
	await t.expect(auxheaderWidth()).gt(1);
});

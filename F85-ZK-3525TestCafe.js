import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3525TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3525.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3525TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq("@grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "0.0";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("1\n0"));
});

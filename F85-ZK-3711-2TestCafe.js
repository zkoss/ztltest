import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3711-2TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3711-2.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3711-2TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9")) {
		console.log("This issue is ignored in current browser! (ie9)");
		return;
	}
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		window.history.back();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText('{"f1":1,'), "It should be f1=1.");
	await ClientFunction(() => {
		window.history.forward();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText('{"f1":3,'), "It should be f1=3.");
});

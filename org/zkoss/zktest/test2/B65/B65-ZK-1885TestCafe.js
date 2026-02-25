import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1885TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1885.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1885TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@div")[0]),
		scrollType: "vertical",
		dist: "100",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.resizeWindow(640, 480);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@div").scrollTop())(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
});

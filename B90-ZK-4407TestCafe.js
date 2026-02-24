import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B90-ZK-4407TestCafe`
	.page`http://localhost:8080/zktest/test2/B90-ZK-4407.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B90-ZK-4407TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ff,edge_legacy,ie11,ie10,ie9,ios")) {
		console.log(
			"This issue is ignored in current browser! (ff,edge_legacy,ie11,ie10,ie9,ios)",
		);
		return;
	}
	await ClientFunction(() => {
		window.scroll(0, 0);
	})();
	await t.eval(() => location.reload(true));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("html").scrollTop())(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t.wait(1000).click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("history.scrollRestoration: auto"));
});

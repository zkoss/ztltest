import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
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
	// scrollRestoration returns to 'auto' only after the widget's 1s timer, which
	// a throttled/background mobile tab can delay well past 1s. Poll for it instead
	// of waiting a fixed time, then read the value the button logs.
	const scrollRestoration = ClientFunction(() => history.scrollRestoration);
	await t.expect(scrollRestoration()).eql("auto", { timeout: 10000 });
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
		.eql(ztl.normalizeText("history.scrollRestoration: auto"));
});

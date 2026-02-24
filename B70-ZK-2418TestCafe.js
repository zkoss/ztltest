import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2418TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2418.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2418TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.hover(Selector(() => zk.Widget.$(jq("@listbox")).$n("hor-embed")));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n("hor")),
		scrollType: "horizontal",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@listbox")).$n()));
	await ClientFunction(() => {
		zk.Widget.$(jq("@listbox")).$n("a").focus();
	})();
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@listbox")).$n("hor-embed")).css("left"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
});

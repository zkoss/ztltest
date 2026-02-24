import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2551TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2551.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2551TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "horizontal",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollLeft({
					locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
				}),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
});

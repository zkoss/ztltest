import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3608TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3608.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3608TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-nav-content")[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-west-body")[0]),
		scrollType: "vertical",
		dist: "1914",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-navitem:last-of-type")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-navitem:last-of-type").attr("class"),
				)(),
			),
		)
		.eql(ztl.normalizeText("z-navitem z-navitem-selected"));
	await t.click(Selector(() => jq(".z-hlayout-inner > button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu").eq(0)[0]));
	await ztl.waitResponse(t);
});

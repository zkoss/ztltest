import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3288904TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3288904.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3288904TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@datebox")).$n("real").focus();
	})();
	await t.pressKey("end");
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq("@datebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("@datebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("0 0 0");
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@datebox")).$n("real")).val(),
				)(),
			),
		)
		.contains(ztl.normalizeText("200000"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@datebox")).$n("real")).val(),
				)(),
			),
		)
		.notContains(ztl.normalizeText("undefined"), "");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3792TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3792.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3792TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq("@datebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("@datebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("3 : 0 0 space a m");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@datebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("03:00 AM"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2080346TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-2080346.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-2080346TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).$n("real").focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq("@combobox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("@combobox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("a enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$copy").val())()),
		)
		.eql(ztl.normalizeText("aa"));
});

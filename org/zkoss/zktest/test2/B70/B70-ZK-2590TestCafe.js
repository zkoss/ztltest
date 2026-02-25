import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2590TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2590.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2590TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-combobox-input")[0]));
	if (
		await ClientFunction(
			() => jq(jq(".z-combobox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-combobox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-combobox-input").val())(),
			),
		)
		.eql(ztl.normalizeText("1A"));
});

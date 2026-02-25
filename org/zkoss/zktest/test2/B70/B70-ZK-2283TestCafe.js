import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2283TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2283.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2283TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-combobox-input")[0]));
	if (
		await ClientFunction(
			() => jq(jq(".z-combobox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-combobox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a").wait(500);
	if (
		await ClientFunction(
			() => jq(jq(".z-combobox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-combobox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("b").wait(500).pressKey("backspace").wait(500);
	if (
		await ClientFunction(
			() => jq(jq(".z-combobox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-combobox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a").wait(500);
	await ztl.waitResponse(t);
	await t.wait(1000);
	let suggestion_cafe = await ClientFunction(() =>
		jq(".z-comboitem-selected .z-comboitem-text").eq(0).html(),
	)();
	await t
		.expect(ztl.normalizeText(suggestion_cafe))
		.contains(
			ztl.normalizeText("aba"),
			"Suggestion fail. Can't match the typing.",
		);
});

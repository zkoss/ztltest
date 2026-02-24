import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B95-ZK-4588TestCafe`
	.page`http://localhost:8080/zktest/test2/B95-ZK-4588.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B95-ZK-4588TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,ie11")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,ie11)",
		);
		return;
	}
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-combobox-input").val())(),
			),
		)
		.eql(ztl.normalizeText("abacus"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-combobox-input")[0].selectionStart,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-combobox-input")[0].selectionEnd,
				)(),
			),
		)
		.eql(ztl.normalizeText("6"));
});

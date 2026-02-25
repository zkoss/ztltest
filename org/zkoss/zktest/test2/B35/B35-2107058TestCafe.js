import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2107058TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2107058.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2107058TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() => jq(jq("$username"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$username")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("h e l l o");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq("$password"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$password")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("w o r l d");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-highlighted .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Login button clicked"));
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$password").focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-highlighted .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Window.onOK triggered, password=world"));
});

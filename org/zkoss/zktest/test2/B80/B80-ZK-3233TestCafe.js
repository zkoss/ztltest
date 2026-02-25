import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3233TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3233.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3233TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(".z-datebox-input:eq(0)").focus();
	})();
	if (
		await ClientFunction(
			() => jq(jq(".z-datebox-input:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-datebox-input:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a").pressKey("tab");
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-textbox:eq(0)").focus();
	})();
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a").pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => jq(".z-tab:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => jq(".z-tab:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3528TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3528.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3528TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@listitem")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => document.activeElement.className)(),
			),
		)
		.eql(ztl.normalizeText("z-focus-a"));
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-listitem").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 0).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => document.activeElement.className)(),
			),
		)
		.eql(ztl.normalizeText("z-focus-a"));
	await t.pressKey("esc");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("[KeyEvent onCancel <Listbox "), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => document.activeElement.className)(),
			),
		)
		.eql(ztl.normalizeText("z-focus-a"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("[KeyEvent onOK <Listbox "), "");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-MVP2MVVMTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-MVP2MVVMTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/mvp2mvvm_mvp.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$textA")).isDisabled(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => zk.Widget.$(jq("$outerToggle1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$textA")).isDisabled(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t.click(Selector(() => zk.Widget.$(jq("$outerToggle2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$textA")).isDisabled(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => zk.Widget.$(jq("$innerToggle")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$textA")).isDisabled(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
});

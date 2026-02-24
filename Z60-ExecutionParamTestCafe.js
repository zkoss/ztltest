import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-ExecutionParamTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ExecutionParamTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/executionparam.zul"/>`);
	await t.click(Selector(() => zk.Widget.$(jq("$btn1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w1").find("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w1").find("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("bar"));
	await t.click(Selector(() => zk.Widget.$(jq("$w1").find("$cmd1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w1").find("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w1").find("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Widget.$(jq("$btn2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w2").find("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("abc"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w2").find("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("goo"));
	await t.click(Selector(() => zk.Widget.$(jq("$w2").find("$cmd1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w2").find("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$w2").find("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-SelectorParamTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-SelectorParamTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/selectorparam.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Init 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Init 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Init 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Init 3:4"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Command 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Command 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Command 2:3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Command 3"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cmd2")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("size 0"));
});

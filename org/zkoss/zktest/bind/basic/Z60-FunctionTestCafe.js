import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-FunctionTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-FunctionTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/function.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo:2bar"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo:foo:b"));
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
		.eql(ztl.normalizeText("foo0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo:2bar"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo0:foo0:b"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1:2bar"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1:foo1:b"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd3")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo1:2bar"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("foo2:foo2:b"));
});

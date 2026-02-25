import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-ScopeParamTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ScopeParamTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/scopeparam.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("applicationScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("sessionScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("desktopScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("spaceScopeScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l15")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("requestScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l16")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("E"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
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
		.eql(ztl.normalizeText("applicationScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("sessionScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("desktopScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("spaceScopeScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l15")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l16")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("F"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("E"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("G"));
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
		.eql(ztl.normalizeText("var2 by Desktop"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("var1 by Desktop"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("desktopScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("spaceScopeScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l15")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l16")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("F"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("E"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("G"));
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
		.eql(ztl.normalizeText("applicationScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("sessionScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("desktopScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("spaceScopeScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l15")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l16")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("F"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("E"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("G"));
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
		.eql(ztl.normalizeText("var2 by Desktop"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("var1 by Desktop"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l13")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("desktopScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l14")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("spaceScopeScope-A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l15")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l16")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("F"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("E"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("G"));
});

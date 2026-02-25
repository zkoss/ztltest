import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-ContextParamTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ContextParamTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/contextparam.zul"/>`);
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
		.eql(ztl.normalizeText("spaceScope-A"));
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
		.eql(ztl.normalizeText("componentScope-B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("vbox1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("vbox1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l1a")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
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
		.eql(ztl.normalizeText("spaceScope-A"));
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
		.eql(ztl.normalizeText("componentScope-C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("cmd1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("vbox1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l1a")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
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
		.eql(ztl.normalizeText("spaceScope-Y"));
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
		.eql(ztl.normalizeText("componentScope-C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("cmd2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("vbox1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l1a")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
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
		.eql(ztl.normalizeText("spaceScope-Y"));
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
		.eql(ztl.normalizeText("componentScope-C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l17")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("cmd3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l18")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("vbox1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l19")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l1a")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
});

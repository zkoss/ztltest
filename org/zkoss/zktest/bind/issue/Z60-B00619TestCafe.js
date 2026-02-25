import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-B00619TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-B00619TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/issue/B00619.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$listbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$tabbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$taba")).isSelected())(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabb")).isSelected())(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabc")).isSelected())(),
		)
		.notOk();
	await t.click(Selector(() => zk.Widget.$(jq("$itema")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$listbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$tabbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$taba")).isSelected())(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabb")).isSelected())(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabc")).isSelected())(),
		)
		.notOk();
	await t.click(Selector(() => zk.Widget.$(jq("$tabc")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$listbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$tabbox")).getSelectedIndex(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$taba")).isSelected())(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabb")).isSelected())(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() => zk.Widget.$(jq("$tabc")).isSelected())(),
		)
		.ok();
});

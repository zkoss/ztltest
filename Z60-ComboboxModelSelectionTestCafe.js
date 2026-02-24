import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-ComboboxModelSelectionTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ComboboxModelSelectionTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/basic/comboboxmodelselection.zul"/>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await ClientFunction(() => {
		zk.Widget.$(jq("$cb1")).open();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("$cb1")).open();
	})();
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq("$cb1").find("@comboitem").eq(1)).$n()),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb1")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb2")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await ClientFunction(() => {
		zk.Widget.$(jq("$cb1")).open();
	})();
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq("$cb1").find("@comboitem").eq(2)).$n()),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb1")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb2")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("reloaded"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb1")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb2")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("selected"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb1")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$cb2")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
});

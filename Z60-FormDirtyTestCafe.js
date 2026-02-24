import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-FormDirtyTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-FormDirtyTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/form-dirty.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$dirty")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Dennis"));
	await ClientFunction(() => {
		zk.Widget.$(jq("$t1")).$n().value = "";
	})();
	if (
		await ClientFunction(
			() => jq(zk.Widget.$(jq("$t1")))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("$t1")).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("X");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$dirty")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("X"));
	await ClientFunction(() => {
		zk.Widget.$(jq("$t1")).$n().value = "";
	})();
	if (
		await ClientFunction(
			() => jq(zk.Widget.$(jq("$t1")))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("$t1")).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("D e n n i s");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$dirty")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Dennis"));
	await ClientFunction(() => {
		zk.Widget.$(jq("$t1")).$n().value = "";
	})();
	if (
		await ClientFunction(
			() => jq(zk.Widget.$(jq("$t1")))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("$t1")).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("Y");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$dirty")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Y"));
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
		.eql(ztl.normalizeText("old-name Dennis"));
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
		.eql(ztl.normalizeText("saved Y"));
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
		.eql(ztl.normalizeText("old-name Y"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$dirty")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Y"));
});

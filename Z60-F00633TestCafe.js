import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-F00633TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-F00633TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/issue/F00633.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onCreate 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onCreate 2"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand1"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand2"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn3")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand3 btn3 true"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn4")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand4 3 false null btn4 true"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn5")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand5 99 true XYZ btn5 true"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn6")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommand6 9 true ABCD btn6 true"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn7")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommandX 9 true XYZ cmd7"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn8")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommandX 22 true ABCD cmd8"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn9")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l11")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("doCommandX 9 false EFG cmd9"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn10")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("object is btn10"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn11")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("object is desktop"));
	await t.click(Selector(() => zk.Widget.$(jq("$btn12")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$l12")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("object is h11"));
});

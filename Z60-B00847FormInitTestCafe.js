import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-B00847FormInitTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-B00847FormInitTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/issue/B00847FormInit.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("blue"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l2")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("blue"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("red"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l2")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("blue"));
	await t.click(Selector(() => zk.Widget.$(jq("$cmd2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("yellow"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l2")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("yellow"));
});

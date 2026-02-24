import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-3588TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-3588.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-3588TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-listheader:eq(0)").width())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-frozen-body:eq(0)").width())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-column:eq(0)").width())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-frozen-body:eq(1)").width())(),
		),
		ztl.normalizeText("2"),
	);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-listbox")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "600.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "600.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listheader-content:contains(5)").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-column-content:contains(5)").width(),
	)();
	await t.expect(verifyVariable_cafe_1_1 > 0).ok();
});

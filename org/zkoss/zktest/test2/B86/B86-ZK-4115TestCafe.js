import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4115TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4115.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4115TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.resizeWindow(600, 800);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-listbox")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "100.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-listbox")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "0.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.resizeWindow(800, 800);
	await ztl.waitResponse(t);
	let w1_cafe = await ClientFunction(() =>
		jq(".z-listheader").eq(0).outerWidth(),
	)();
	let w2_cafe = await ClientFunction(() =>
		jq(".z-listheader").eq(1).outerWidth(),
	)();
	let w3_cafe = await ClientFunction(() =>
		jq(".z-listheader").eq(2).outerWidth(),
	)();
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-listbox")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "100.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-listbox")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "0.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w1_cafe),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-listheader").eq(0).outerWidth(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w2_cafe),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-listheader").eq(1).outerWidth(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w3_cafe),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-listheader").eq(2).outerWidth(),
			)(),
		),
		ztl.normalizeText("2"),
	);
});

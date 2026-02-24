import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2890515TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2890515.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2890515TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("dtbx", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dtbx", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dtbx", true).$n("real")),
		ztl.normalizeText("20091102"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk(
			"should not show error with date before (and include) 2009/11/02",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("dtbx", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dtbx", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dtbx", true).$n("real")),
		ztl.normalizeText("20091103"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("should show error with date after 2009/11/02");
});

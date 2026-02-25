import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3352909TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3352909.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3352909TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@listbox")).$n("body")).scrollTop(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 2000).ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@grid")).$n()),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(500);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@grid")).$n("body")).scrollTop(),
	)();
	await t.expect(verifyVariable_cafe_1_1 > 2000).ok();
});

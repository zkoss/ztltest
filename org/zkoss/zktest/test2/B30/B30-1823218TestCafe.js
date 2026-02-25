import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823218TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1823218.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1823218TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("tree", true).$n("body")).offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("tree", true).$n("head")).offset().top,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tree", true).$n("head")).height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("tree", true).$n("body")).offset().top,
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("tree", true).$n("head")).offset().top,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tree", true).$n("head")).height(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0),
		ztl.normalizeText(verifyVariable_cafe_4_4 + verifyVariable_cafe_5_5),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => zk.Widget.$(jq("@button")).$n()));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tree", true)).width(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tree", true).$n("body")).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tree", true)).height(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tree", true).$n("body")).outerHeight(),
			)(),
		),
		ztl.normalizeText("1"),
	);
});

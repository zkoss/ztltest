import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B95-ZK-4741TestCafe`
	.page`http://localhost:8080/zktest/test2/B95-ZK-4741.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B95-ZK-4741TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$("@tree").$n()),
		scrollType: "vertical",
		dist: "10000",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$("@tree").$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("tpad")).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("cave")).height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("bpad")).height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(zk.Widget.$("@tree").$n("body"))[0].scrollHeight,
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("tpad")).height(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("cave")).height(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(zk.Widget.$("@tree").$n("bpad")).height(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(
		() => jq(zk.Widget.$("@tree").$n("body"))[0].scrollHeight,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_3_3),
		ztl.normalizeText(
			verifyVariable_cafe_4_4 +
				verifyVariable_cafe_5_5 +
				verifyVariable_cafe_6_6,
		),
		ztl.normalizeText("2"),
	);
});

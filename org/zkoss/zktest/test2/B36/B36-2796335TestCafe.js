import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2796335TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2796335.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2796335TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let expectedDiv1_cafe_0 = await ClientFunction(() =>
		jq("@div:eq(0)").outerHeight(),
	)();
	let expectedDiv1_cafe_1 = await ClientFunction(
		() => jq("@div:eq(0)")[0].scrollHeight,
	)();
	let expectedDiv1_cafe = expectedDiv1_cafe_1 - expectedDiv1_cafe_0;
	let expectedDiv2_cafe_2 = await ClientFunction(
		() => jq("@div:eq(1)")[0].scrollHeight,
	)();
	let expectedDiv2_cafe_3 = await ClientFunction(() =>
		jq("@div:eq(1)").outerHeight(),
	)();
	let expectedDiv2_cafe = expectedDiv2_cafe_2 - expectedDiv2_cafe_3;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(expectedDiv1_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@div:eq(0)").scrollTop())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(expectedDiv2_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@div:eq(1)").scrollTop())(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@div:eq(0)").scrollTop())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@div:eq(1)").scrollTop())(),
		),
		ztl.normalizeText("1"),
	);
});

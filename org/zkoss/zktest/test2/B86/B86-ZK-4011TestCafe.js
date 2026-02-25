import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4011TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4011.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4011TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9,ie10,ie11")) {
		console.log(
			"This issue is ignored in current browser! (ie9,ie10,ie11)",
		);
		return;
	}
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@cell:eq(0)")[0].clientWidth)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@cell:eq(3)")[0].clientWidth)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@cell:eq(5)")[0].clientWidth)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@auxheader:eq(2)")[0].clientWidth)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button:contains(switch 1 visible)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => jq("@cell:eq(0)")[0].clientWidth)(),
	);
	await t.expect(verifyVariable_cafe_0_0 > 1).ok();
	await t.click(Selector(() => jq("@button:contains(switch 6 visible)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() => jq("@cell:eq(5)")[0].clientWidth)(),
	);
	await t.expect(verifyVariable_cafe_1_1 > 1).ok();
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(() => jq("@auxheader:eq(2)")[0].clientWidth)(),
	);
	await t.expect(verifyVariable_cafe_2_2 > 1).ok();
});

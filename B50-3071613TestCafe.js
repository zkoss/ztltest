import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3071613TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3071613.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3071613TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.typeText(
		Selector(() => jq("@decimalbox")[0]),
		ztl.normalizeText("12.123"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox").val())(),
			),
		)
		.eql(ztl.normalizeText("12.12"));
	await ClientFunction(() => {
		zk.Widget.$(jq("@decimalbox")).$n().value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@decimalbox")[0]),
		ztl.normalizeText("12.125"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox").val())(),
			),
		)
		.eql(ztl.normalizeText("12.13"));
});

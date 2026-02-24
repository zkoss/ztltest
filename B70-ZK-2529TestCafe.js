import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2529TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2529.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2529TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.typeText(
		Selector(() => jq(".z-textbox").eq(0)[0]),
		ztl.normalizeText("chunfu"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox").eq(0).val())(),
			),
		)
		.eql(ztl.normalizeText("chunfu"));
	await t.typeText(
		Selector(() => jq(".z-textbox").eq(1)[0]),
		ztl.normalizeText("chunfu"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox").eq(1).val())(),
			),
		)
		.eql(ztl.normalizeText("chunfu"));
	await t.typeText(
		Selector(() => jq(".z-textbox").eq(2)[0]),
		ztl.normalizeText("chunfu"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox").eq(2).val())(),
			),
		)
		.eql(ztl.normalizeText("chunfu"));
});

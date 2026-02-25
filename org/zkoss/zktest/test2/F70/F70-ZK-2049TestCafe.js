import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F70-ZK-2049TestCafe`
	.page`http://localhost:8080/zktest/test2/F70-ZK-2049.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F70-ZK-2049TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq(".z-button").eq(0)[0]),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-menupopup")[0])(),
			),
		)
		.eql(ztl.normalizeText("true"), "open the menupopup");
	await t.click(
		Selector(() => jq(".z-button").eq(0)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-menupopup").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("false"), "it will close");
	await t.rightClick(
		Selector(() => jq(".z-button").eq(1)[0]),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-menupopup")[0])(),
			),
		)
		.eql(ztl.normalizeText("true"), "open the menupopup");
	await t.rightClick(
		Selector(() => jq(".z-button").eq(1)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-menupopup").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("false"), "it will close");
});

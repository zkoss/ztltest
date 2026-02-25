import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-1962310TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-1962310.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-1962310TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listitem-selected")[0]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").index(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").index(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").index(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").index(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});

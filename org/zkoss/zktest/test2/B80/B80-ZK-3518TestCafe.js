import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3518TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3518.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3518TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => jq(".z-groupbox-content")[0]),
		Selector(() => jq(".z-div:eq(1)")[0]),
		{
			offsetX: 0,
			offsetY: 0,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.dragToElement(
		Selector(() => jq(".z-div:eq(0)")[0]),
		Selector(() => jq(".z-div:eq(1)")[0]),
		{
			offsetX: 0,
			offsetY: 0,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});

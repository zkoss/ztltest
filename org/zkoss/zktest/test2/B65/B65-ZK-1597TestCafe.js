import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1597TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1597.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1597TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => jq(".z-tab:contains(Items)")[0]),
		Selector(() => jq(".z-tab:contains(tab 1)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 2,
			destinationOffsetY: 2,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tab:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText("Items"),
			"The tab 'Items' should be selected and the content displays the first tabpanel.",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-tabpanel:eq(0) .z-label:contains(1)")[0],
			)(),
		)
		.ok(
			"The tab 'Items' should be selected and the content displays the first tabpanel.",
		);
});

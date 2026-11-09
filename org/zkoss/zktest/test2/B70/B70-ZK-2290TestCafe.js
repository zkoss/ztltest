import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2290TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2290.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2290TestCafe", async (t) => {
	await ztl.initTest(t);
	// drop the column's right edge at the listbox's right edge, so the other columns leave the view at any window width
	await t.dragToElement(
		Selector(".z-listheader").nth(1),
		Selector(".z-listbox-body"),
		{
			offsetX: -3,
			offsetY: 10,
			destinationOffsetX: -3,
			destinationOffsetY: 10,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasHScrollbar({
				locator: Selector(() => jq(".z-listbox-body")[0]),
			}),
		)
		.ok("browser should show scrollbar.");
});

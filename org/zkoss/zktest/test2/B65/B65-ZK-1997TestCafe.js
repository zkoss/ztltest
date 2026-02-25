import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1997TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1997.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1997TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => jq(".z-panel")[0]),
		Selector(() => jq(".z-panel")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 10,
			destinationOffsetY: 10,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window")[0])())
		.notOk("You should not see any dialog.");
});

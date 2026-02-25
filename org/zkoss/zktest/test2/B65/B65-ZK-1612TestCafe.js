import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1612TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1612.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1612TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("img[src*=button]")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok("You should see a dialog");
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let headerText_cafe = await ClientFunction(() =>
		jq(".z-panel-header:eq(1)").text().replace(/\s/g, " "),
	)();
	await t.dragToElement(
		Selector(() => jq("img[src*=button]")[0]),
		Selector(() => jq(".z-panel-body:eq(1)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 2,
			destinationOffsetY: 2,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(headerText_cafe))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-panel-header:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
			"You should see the title of the right side panel is changed.",
		);
});

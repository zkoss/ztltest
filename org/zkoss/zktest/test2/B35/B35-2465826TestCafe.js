import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2465826TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2465826.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2465826TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listitem").eq(1)[0]));
	await ztl.waitResponse(t);
	let itemText_cafe = await ClientFunction(() =>
		jq(".z-listitem-selected").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(itemText_cafe))
		.notEql(ztl.normalizeText(""), "The selection cannot be empty");
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok("The Messagebox should be visible");
	await t.pressKey("enter");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(itemText_cafe), "The selected item changed");
});

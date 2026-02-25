import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1142TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1142.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1142TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@menu:contains(File)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menuitem:contains(Document)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Document"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window @label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should see alert message displayed",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menu:contains(File)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menuitem:contains(Spreadsheet)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Spreadsheet"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window @label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should see alert message displayed",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menu:contains(File)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-menu:contains(New)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menuitem:contains(Presentation)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Presentation"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window @label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should see alert message displayed",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
});

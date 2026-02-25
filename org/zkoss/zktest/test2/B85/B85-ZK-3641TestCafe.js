import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3641TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3641.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3641TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("hidden"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-iframe").css("visibility"))(),
			),
		);
	await t.click(Selector(() => jq(".z-label")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("hidden"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-iframe").css("visibility"))(),
			),
		);
	await t.click(Selector(() => jq(".z-label")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-colorbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("hidden"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-iframe").css("visibility"))(),
			),
		);
	await t.click(Selector(() => jq(".z-label")[0]));
	await ztl.waitResponse(t);
});

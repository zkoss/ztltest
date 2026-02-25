import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2447TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2447.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2447TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listitem:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listitem").last()[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Show)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-notification-content:last")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Show)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-notification-content:last")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});

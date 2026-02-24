import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3833TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3833.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3833TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-datebox-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-selected:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-datebox-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-selected:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		);
	await ztl.waitResponse(t);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3619TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3619.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3619TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-left")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-left")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(".z-calendar-cell.z-calendar-disabled:visible")
							.length,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-calendar-cell:visible").length,
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-right")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(".z-calendar-cell.z-calendar-disabled:visible")
							.length,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-calendar-cell:visible").length,
				)(),
			),
		);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1768TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1768.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1768TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-row:contains(Item 2) input")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Show Index)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(index: 1)")[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-button:contains(Replace Model)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Show Index)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(index: -1)")[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-row:contains(Item 2) input")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Show Index)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(index: 1)")[0],
			)(),
		)
		.ok();
});

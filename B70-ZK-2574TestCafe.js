import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2574TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2574.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2574TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$status").html())(),
			),
		)
		.eql(ztl.normalizeText("started"));
	await t.wait(2100);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$status").html())(),
			),
		)
		.eql(ztl.normalizeText("finished"));
	await t.click(Selector(() => jq("$btn2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$status").html())(),
			),
		)
		.eql(ztl.normalizeText("started"));
	await t.wait(2100);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$status").html())(),
			),
		)
		.eql(ztl.normalizeText("finished"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3784TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3784.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3784TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging:eq(0)")
						.find(".z-paging-info")
						.css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("hidden"), "Paging detail should be hidden");
	await t.click(Selector(() => jq("@button").eq(4)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging:eq(0)")
						.find(".z-paging-info")
						.css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("visible"), "Paging detail should be visible");
});

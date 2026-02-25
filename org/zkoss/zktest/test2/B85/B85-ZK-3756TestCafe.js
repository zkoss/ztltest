import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3756TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3756.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3756TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@include").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("included"), "");
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@include").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@include:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("included"), "");
});

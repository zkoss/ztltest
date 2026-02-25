import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1979088TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1979088.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1979088TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0])).wait(1000);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("red"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-paging:eq(0)").css("backgroundColor"),
					)(),
				),
			),
		)
		.ok();
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("red"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-paging:eq(1)").css("backgroundColor"),
					)(),
				),
			),
		)
		.ok();
});

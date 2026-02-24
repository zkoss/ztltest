import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3016TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3016.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3016TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.expect(await ClientFunction(() => !!jq("$btn1")[0])()).ok();
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab2").offset().top)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab1").offset().top)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab3").offset().top)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab2").offset().top)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab4").offset().top)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tab3").offset().top)(),
			),
		);
});

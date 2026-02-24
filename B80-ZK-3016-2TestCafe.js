import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3016-2TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B80-ZK-3016-2TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B80-ZK-3016.zul"/>`);
	await t.expect(await ClientFunction(() => !!jq("$btn3")[0])()).ok();
	await t.click(Selector(() => jq("$btn3")[0]));
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

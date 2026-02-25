import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3754TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3754.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3754TestCafe", async (t) => {
	await ztl.initTest(t);
	let navWidth_cafe = await ClientFunction(() =>
		jq(".z-nav:eq(0)").outerWidth(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-nav:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText(navWidth_cafe));
});

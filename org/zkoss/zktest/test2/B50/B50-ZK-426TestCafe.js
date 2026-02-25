import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-426TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-426.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-426TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq(".z-intbox").eq(1))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-intbox").eq(1)[0]),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-intbox").eq(1).val())(),
			),
		)
		.eql(ztl.normalizeText("123"));
});

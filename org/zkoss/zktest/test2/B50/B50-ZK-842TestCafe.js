import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-842TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-842.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-842TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq(".z-intbox"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-intbox")[0]),
		ztl.normalizeText("-1"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("should see an error message.");
});

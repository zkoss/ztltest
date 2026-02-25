import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2975TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2975.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2975TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq(".z-datebox-input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-datebox-input")[0]),
		ztl.normalizeText("mars 2015"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-errorbox").is(":visible"))())
		.notOk();
});

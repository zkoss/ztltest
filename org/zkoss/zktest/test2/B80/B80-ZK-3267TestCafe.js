import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3267TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3267.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3267TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@combobox")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq(".z-combobox-input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-combobox-input")[0]),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-combobox-popup")[0])())
		.notOk();
});

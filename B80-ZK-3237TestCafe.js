import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3237TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3237.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3237TestCafe", async (t) => {
	await ztl.initTest(t);
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
	await ClientFunction(() => {
		jq(jq(".z-textbox"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-textbox")[0]),
		ztl.normalizeText("aa"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox").val())(),
			),
		)
		.eql(ztl.normalizeText("aa"));
});

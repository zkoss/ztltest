import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1486556TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1486556.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1486556TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(".z-textbox").focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-textbox").hasClass("z-textbox-invalid"),
			)(),
		)
		.ok();
});

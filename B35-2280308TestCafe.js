import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2280308TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2280308.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2280308TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@panelchildren")[0]),
		scrollType: "vertical",
		dist: await ClientFunction(
			() => jq("@panelchildren")[0].scrollHeight,
		)(),
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("It should be visible an error box");
});

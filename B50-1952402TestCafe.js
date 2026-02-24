import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-1952402TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-1952402.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-1952402TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("@window iframe").contents().find(".z-button").click();
	})();
	await ztl.waitResponse(t);
	let textboxVal_cafe = await ClientFunction(() =>
		jq("@window iframe").contents().find(".z-textbox").val(),
	)();
	await t
		.expect(ztl.normalizeText(textboxVal_cafe))
		.eql(ztl.normalizeText("1"));
});

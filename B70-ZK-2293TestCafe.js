import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2293TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2293.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2293TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	let w1_cafe = await ClientFunction(() => jq(".z-bandbox-popup").width())();
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	let w2_cafe = await ClientFunction(() => jq(".z-bandbox-popup").width())();
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(w1_cafe == w2_cafe)
		.ok("the width of popup in two times should be the same.");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-3014TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-3014.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-3014TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq(".z-bandbox-button")[0]))
		.click(Selector(() => jq(".z-button:contains(change model)")[0]))
		.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listbox").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 2).ok();
});

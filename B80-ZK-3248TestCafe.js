import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3248TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3248.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3248TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	let gbBeforeWidth_cafe = await ClientFunction(() =>
		jq(".z-groupbox").width(),
	)();
	await t.click(Selector(() => jq('.z-label:contains("groupbox 1")')[0]));
	await ztl.waitResponse(t);
	let gbAfterWidth_cafe = await ClientFunction(() =>
		jq(".z-groupbox").width(),
	)();
	await t
		.expect(gbAfterWidth_cafe < gbBeforeWidth_cafe)
		.ok(
			"Expecting " +
				gbAfterWidth_cafe +
				" to be smaller than " +
				gbBeforeWidth_cafe,
		);
	await t.click(Selector(() => jq('.z-label:contains("groupbox 1")')[0]));
	await ztl.waitResponse(t);
	let pcBeforeWidth_cafe = await ClientFunction(() =>
		jq(".z-portalchildren").width(),
	)();
	await t.click(Selector(() => jq(".z-panel-icon.z-panel-expand").eq(0)[0]));
	await ztl.waitResponse(t);
	let pcAfterWidth_cafe = await ClientFunction(() =>
		jq(".z-portalchildren").width(),
	)();
	await t
		.expect(pcAfterWidth_cafe < pcBeforeWidth_cafe)
		.ok(
			"Expecting " +
				pcAfterWidth_cafe +
				" to be smaller than " +
				pcBeforeWidth_cafe,
		);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2802TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2802TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B70-ZK-2802.zul"/>`);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@toolbarbutton:first").outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@toolbarbutton:first img").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > verifyVariable_cafe_1_1).ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("@toolbarbutton:first img").outerWidth(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("@toolbarbutton:first").outerWidth(),
	)();
	await t.expect(verifyVariable_cafe_3_3 > verifyVariable_cafe_2_2).ok();
});

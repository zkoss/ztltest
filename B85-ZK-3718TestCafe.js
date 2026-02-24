import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3718TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3718.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3718TestCafe", async (t) => {
	await ztl.initTest(t);
	let height_cafe = await ClientFunction(() => jq("@vlayout").height())();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-vlayout-inner:last").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-vlayout-inner:last").offset().top,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-vlayout-inner:last").height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-vlayout-inner:last").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(height_cafe),
		ztl.normalizeText(verifyVariable_cafe_3_3 + verifyVariable_cafe_2_2),
		ztl.normalizeText("3"),
	);
});

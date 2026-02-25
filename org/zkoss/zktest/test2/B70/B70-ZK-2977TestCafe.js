import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2977TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2977.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2977TestCafe", async (t) => {
	await ztl.initTest(t);
	let comboboxBottom_cafe_0 = await ClientFunction(() =>
		jq(".z-combobox").eq(1).height(),
	)();
	let comboboxBottom_cafe_1 = await ClientFunction(
		() => jq(".z-combobox").eq(1).offset().top,
	)();
	let comboboxBottom_cafe = comboboxBottom_cafe_1 + comboboxBottom_cafe_0;
	await ClientFunction(() => {
		window.scrollTo(0, 1005);
	})();
	let actionVariable_cafe_0_2 = await ClientFunction(() =>
		jq(".z-combobox").eq(1).height(),
	)();
	await ClientFunction(
		() => {
			"window.scrollBy(0,-" + actionVariable_cafe_0_2 + ")";
		},
		{ dependencies: { actionVariable_cafe_0_2 } },
	)();
	await t.click(Selector(() => jq(".z-combobox-button").eq(1)[0]));
	await ztl.waitResponse(t);
	let actionVariable_cafe_1_3 = await ClientFunction(() =>
		jq(".z-combobox").eq(1).height(),
	)();
	await ClientFunction(
		() => {
			"window.scrollBy(0," + actionVariable_cafe_1_3 + ")";
		},
		{ dependencies: { actionVariable_cafe_1_3 } },
	)();
	let verifyVariable_cafe_0_4 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	await t.expect(verifyVariable_cafe_0_4 >= comboboxBottom_cafe).ok();
});

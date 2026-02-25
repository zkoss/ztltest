import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3217TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3217.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3217TestCafe", async (t) => {
	await ztl.initTest(t);
	let clientHeight_cafe = parseInt(
		await ClientFunction(() => document.documentElement.clientHeight)(),
	);
	let offset_cafe_0 = await ClientFunction(
		() => jq("@datebox").offset().top,
	)();
	let offset_cafe_1 = await ClientFunction(() =>
		jq("@datebox").outerHeight(),
	)();
	let offset_cafe = offset_cafe_0 + offset_cafe_1 - clientHeight_cafe;
	await ClientFunction(
		() => {
			"window.scrollTo(0," + offset_cafe + ")";
		},
		{ dependencies: { offset_cafe } },
	)();
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	let orgHeight_cafe = await ClientFunction(
		() => jq(".z-datebox-popup").position().top,
	)();
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-datebox-popup").position().top,
				)(),
			),
		)
		.eql(ztl.normalizeText(orgHeight_cafe));
});

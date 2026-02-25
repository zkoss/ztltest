import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-559TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-559.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-559TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("listbox", true).$n()).offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("listbox", true).$n()).height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("tabbox", true).$n()).offset().top,
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_2_2 +
							"-" +
							verifyVariable_cafe_1_1 +
							"-" +
							verifyVariable_cafe_0_0 +
							") < 15",
					),
				{
					dependencies: {
						verifyVariable_cafe_2_2,
						verifyVariable_cafe_1_1,
						verifyVariable_cafe_0_0,
					},
				},
			)(),
		)
		.ok("the gap between listbox and tabbox should not too large");
});

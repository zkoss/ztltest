import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-577TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-577.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-577TestCafe", async (t) => {
	await ztl.initTest(t);
	let dbxLeft_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("dbx", true).$n()).offset().left,
	)();
	let btn1Left_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btn1", true).$n()).offset().left,
	)();
	let btn2Left_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btn2", true).$n()).offset().left,
	)();
	let dbxTop_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("dbx", true).$n()).offset().top,
	)();
	let btn1Top_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btn1", true).$n()).offset().top,
	)();
	let btn2Top_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btn2", true).$n()).offset().top,
	)();
	let dbxWidth_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("dbx", true).$n()).outerWidth(),
	)();
	let btn1Width_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("btn1", true).$n()).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							btn1Top_cafe +
							"-" +
							dbxTop_cafe +
							") <= 10",
					),
				{ dependencies: { btn1Top_cafe, dbxTop_cafe } },
			)(),
		)
		.ok("The top of datebox and button 1 should almost the same");
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							btn2Top_cafe +
							"-" +
							dbxTop_cafe +
							") <= 10",
					),
				{ dependencies: { btn2Top_cafe, dbxTop_cafe } },
			)(),
		)
		.ok("The top of datebox and button 2 should almost the same");
	await t
		.expect(btn1Left_cafe >= dbxLeft_cafe + dbxWidth_cafe)
		.ok("The left of button 1 should larger then the right of datebox");
	await t
		.expect(btn2Left_cafe >= btn1Left_cafe + btn1Width_cafe)
		.ok("The left of button 2 should larger then the right of button 1");
});

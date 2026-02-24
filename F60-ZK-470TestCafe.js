import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-470TestCafe`
	.page`http://localhost:8080/zktest/test2/F60-ZK-470.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F60-ZK-470TestCafe", async (t) => {
	await ztl.initTest(t);
	let parentW_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("al", true).$n()).width(),
	)();
	let parentH_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("al", true).$n()).height(),
	)();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerWidth(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_1_1 +
							" - " +
							(parentW_cafe - 100) +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_1_1, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + (parentW_cafe - 100));
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerHeight(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_3_3 +
							" - " +
							200 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_3_3 } },
			)(),
		)
		.ok("Ths window size should be 200");
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerWidth(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_5_5 +
							" - " +
							parentW_cafe * 0.5 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_5_5, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentW_cafe * 0.5);
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerHeight(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_7_7 +
							" - " +
							(parentH_cafe - 200) +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_7_7, parentH_cafe } },
			)(),
		)
		.ok("Ths window size should be " + (parentH_cafe - 200));
	let verifyVariable_cafe_8_8 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerWidth(),
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_9_9 +
							" - " +
							parentW_cafe * 0.25 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_9_9, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentW_cafe * 0.25);
	let verifyVariable_cafe_10_10 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerHeight(),
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_11_11 +
							" - " +
							parentH_cafe * 0.2 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_11_11, parentH_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentH_cafe * 0.2);
	let verifyVariable_cafe_12_12 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win4", true)).outerWidth(),
	)();
	let verifyVariable_cafe_13_13 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win4", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_13_13 +
							" - " +
							parentW_cafe * 0.25 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_13_13, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentW_cafe * 0.25);
	let verifyVariable_cafe_14_14 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win4", true)).outerHeight(),
	)();
	let verifyVariable_cafe_15_15 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win4", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_15_15 +
							" - " +
							parentH_cafe * 0.2 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_15_15, parentH_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentH_cafe * 0.2);
	let verifyVariable_cafe_16_16 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win5", true)).outerWidth(),
	)();
	let verifyVariable_cafe_17_17 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win5", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_17_17 +
							" - " +
							parentW_cafe * 0.25 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_17_17, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentW_cafe * 0.25);
	let verifyVariable_cafe_18_18 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win5", true)).outerHeight(),
	)();
	let verifyVariable_cafe_19_19 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win5", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_19_19 +
							" - " +
							parentH_cafe * 0.2 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_19_19, parentH_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentH_cafe * 0.2);
	let verifyVariable_cafe_20_20 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win6", true)).outerWidth(),
	)();
	let verifyVariable_cafe_21_21 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win6", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_21_21 +
							" - " +
							parentW_cafe * 0.25 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_21_21, parentW_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentW_cafe * 0.25);
	let verifyVariable_cafe_22_22 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win6", true)).outerHeight(),
	)();
	let verifyVariable_cafe_23_23 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win6", true)).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_23_23 +
							" - " +
							parentH_cafe * 0.2 +
							") < 2",
					),
				{ dependencies: { verifyVariable_cafe_23_23, parentH_cafe } },
			)(),
		)
		.ok("Ths window size should be " + parentH_cafe * 0.2);
});

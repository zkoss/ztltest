import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2980383TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2980383.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2980383TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("tabs", true).$n().scrollLeft,
		)(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("tabs", true).$n().offsetWidth,
		)(),
	);
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("last", true).$n().offsetLeft,
		)(),
	);
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("last", true).$n().offsetWidth,
		)(),
	);
	let verifyVariable_cafe_4_4 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("tabs", true).$n().scrollLeft,
		)(),
	);
	let verifyVariable_cafe_5_5 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("tabs", true).$n().offsetWidth,
		)(),
	);
	let verifyVariable_cafe_6_6 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("last", true).$n().offsetLeft,
		)(),
	);
	let verifyVariable_cafe_7_7 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("last", true).$n().offsetWidth,
		)(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0 + verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_6_6 + verifyVariable_cafe_7_7),
		ztl.normalizeText("1"),
	);
});

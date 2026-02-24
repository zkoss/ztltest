import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2890514TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2890514.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2890514TestCafe", async (t) => {
	await ztl.initTest(t);
	let width_cafe_0 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("row1", true).$n())
				.find(".z-row-content")
				.eq(0)
				.css("padding-right"),
		)(),
	);
	let width_cafe_1 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("row1", true).$n())
				.find(".z-row-content")
				.eq(0)
				.css("padding-left"),
		)(),
	);
	let width_cafe_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("row1", true).$n())
			.find(".z-row-inner")
			.eq(0)
			.innerWidth(),
	)();
	let width_cafe = width_cafe_2 - width_cafe_0 - width_cafe_1;
	let flOffsetLeft_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("fl", true).$n().offsetLeft,
		)(),
	);
	let flWd_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("fl", true).$n()).outerWidth(),
	)();
	await ztl.waitResponse(t);
	await t
		.expect(flOffsetLeft_cafe > width_cafe - flWd_cafe)
		.ok(
			"the offsetLeft of File label should close to the right side of row1",
		);
});

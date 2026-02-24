//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1407TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1407.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1407TestCafe", async (t) => {
	await ztl.initTest(t);
	let initColor_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("real")).css("background-color"),
	)();
	let isYellow_cafe =
		initColor_cafe == "yellow" || initColor_cafe == "rgb(255, 255, 0)";
	await t
		.expect(isYellow_cafe)
		.ok("Combobox's initial background color is yellow");
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	let afterClickColor_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("real")).css("background-color"),
	)();
	let isGreen_cafe =
		afterClickColor_cafe == "green" ||
		afterClickColor_cafe == "rgb(0, 128, 0)";
	await t
		.expect(isGreen_cafe)
		.ok("Combobox's initial background color is green");
	await t.click(Selector(() => jq("@comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	let selectColor_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("real")).css("background-color"),
	)();
	let isGreenAgain_cafe =
		selectColor_cafe == "green" || selectColor_cafe == "rgb(0, 128, 0)";
	await t
		.expect(isGreenAgain_cafe)
		.ok("Combobox's initial background color is green");
});

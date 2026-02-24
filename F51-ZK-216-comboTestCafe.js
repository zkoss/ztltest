import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F51-ZK-216-comboTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F51-ZK-216-comboTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				<html><![CDATA[
				<ul><li>Click the dropdown, you shall three items: "Apple: 10kg", "Orange: 20kg" and "Mango: 12kg"</li></ul>
				]]></html>
				<zscript>
				ListModel infos = new ListModelArray(
					new String[][] {
						{"Apple", "10kg"},
						{"Orange", "20kg"},
						{"Mango", "12kg"}
					});
				</zscript>			
				<combobox id="cbx" model="\${infos}">
					<template name="model">
						<comboitem label="\${each[0]}: \${each[1]}"/>
					</template>
				</combobox>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("btn")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(".z-comboitem:contains(Apple)").find(
				".z-comboitem-text:contains(10kg)",
			)[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-comboitem:contains(Apple)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1 && verifyVariable_cafe_0_0)
		.ok("Has item Apple: 10kg");
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() =>
			!!jq(".z-comboitem:contains(Orange)").find(
				".z-comboitem-text:contains(20kg)",
			)[0],
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => !!jq(".z-comboitem:contains(Orange)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_3_3 && verifyVariable_cafe_2_2)
		.ok("Has item Orange: 20kg");
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => !!jq(".z-comboitem:contains(Mango)")[0],
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() =>
			!!jq(".z-comboitem:contains(Mango)").find(
				".z-comboitem-text:contains(12kg)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_4_4 && verifyVariable_cafe_5_5)
		.ok("Has item Mango: 12kg");
});

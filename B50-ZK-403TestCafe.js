import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-403TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-403TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript><![CDATA[
					String[] dictionary = { "abacus", "abase", "barcarole", "barefaced", "cadence", "cadenza", "death\'s-head", "debacle", "endear", "endemic", "endue", "facial", "facile", "facilitate", "gaiety", "gaily", "gainsay", "writhe", "writing", "wry", };
					
					ListModel dictModel= new SimpleListModel(dictionary);
					]]>
				</zscript>
				<div>
					Please test the following steps 4~5 times and each time test you have to reload this case.
					<separator/>
					1. type \'a\' in the inputbox and the dropdownlist shall show 2 items. (please focus into the inputbox and type rapidly)
					
				</div>
				<combobox id="cb" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb2" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb3" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb4" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb5" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
			</zk>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")))
		.typeText(
			Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")),
			ztl.normalizeText("a"),
		);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("cb", true).$n("cave")).children().length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 2).ok();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb2", true).$n("real")))
		.typeText(
			Selector(() => zk.Desktop._dt.$f("cb2", true).$n("real")),
			ztl.normalizeText("a"),
		);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("cb2", true).$n("cave")).children().length,
	)();
	await t.expect(verifyVariable_cafe_0_0t == 2).ok();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb3", true).$n("real")))
		.typeText(
			Selector(() => zk.Desktop._dt.$f("cb3", true).$n("real")),
			ztl.normalizeText("a"),
		);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("cb3", true).$n("cave")).children().length,
	)();
	await t.expect(verifyVariable_cafe_0_0tt == 2).ok();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb4", true).$n("real")))
		.typeText(
			Selector(() => zk.Desktop._dt.$f("cb4", true).$n("real")),
			ztl.normalizeText("a"),
		);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("cb4", true).$n("cave")).children().length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttt == 2).ok();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb5", true).$n("real")))
		.typeText(
			Selector(() => zk.Desktop._dt.$f("cb5", true).$n("real")),
			ztl.normalizeText("a"),
		);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("cb5", true).$n("cave")).children().length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttt == 2).ok();
});

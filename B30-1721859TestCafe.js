import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1721859TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1721859TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window xmlns:html="http://www.w3.org/1999/xhtml">
				Won\'t show in IE due to table structure
				<style>
				.blue { background-color: blue; }
				.green { background-color: green; }
				</style>
				
				Each 25%
				<hbox pack="stretch" width="100%" >
				 <vbox id="v1" pack="stretch" sclass="blue" width="50%"> Left </vbox>
				 <vbox id="v2" pack="stretch" sclass="green" width="50%"> Right </vbox>
				</hbox>
				Each 50%
				<hbox pack="stretch" width="100%" >
				 <vbox id="v3" pack="stretch" sclass="blue" width="100%"> Left </vbox>
				 <vbox id="v4" pack="stretch" sclass="green" width="100%"> Right </vbox>
				</hbox>
			</window>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("v1", true).$n().parentNode).outerWidth(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("v1", true)).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1 - verifyVariable_cafe_0_0 / 2 <= 2)
		.ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("v2", true)).outerWidth(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("v2", true).$n().parentNode).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_2_2 - verifyVariable_cafe_3_3 / 2 <= 2)
		.ok();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("v3", true).$n().parentNode).outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("v3", true)).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("v4", true).$n().parentNode).outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("v4", true)).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F51-ZK-139TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F51-ZK-139TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vlayout>
				<html><![CDATA[
				<ol>
				<li>Press the "create after..." button and a set of components will be created and appended at the end.</li>
				<li>Press again and a new set will be append.</li>
				<li>Press the "create before..." button and a set of components will be created and inserted before the button.</li>
				<li>Press again and a new set will be inserted.</li>
				</ol>
				]]></html>
			
				<template name="t1">
					\${count}: This is date: <datebox/>
					This is native:
						<n:ol xmlns:n="native">
							<n:li>first item</n:li>
							<n:li>second item</n:li>
						</n:ol>
			
					This is listbox
					<zscript>
					ListModel infos = new ListModelArray(
						new String[][] {
							{"Apple", "10kg"},
							{"Orange", "20kg"},
							{"Mango", "12kg"}
						});
					</zscript>
					<listbox model="\${infos}">
						<listhead>
							<listheader label="Name"/>
						</listhead>
					</listbox>
				</template>
				<zscript>
				public class VResolver implements org.zkoss.xel.VariableResolver {
					int count = 0;
					public Object resolveVariable(String name) {
						if ("count".equals(name))
							return ++count;
						return null;
					}
				}
				VResolver resolver = new VResolver();
				</zscript>		
			
				<button id="btnOne" label="create after from template"
					onClick=\'self.parent.getTemplate("t1").create(self.parent, null, resolver, null)\'/>
				<button id="btnTwo" label="create before from template"
					onClick=\'self.parent.getTemplate("t1").create(self.parent, self, resolver, null)\'/>
			</vlayout>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btnTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-label:contains(1: This is date:)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_3_3 > verifyVariable_cafe_2_2)
		.ok("Template should inserted after");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btnTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(
		() => jq(".z-label:contains(2: This is date:)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_3_3t > verifyVariable_cafe_2_2t)
		.ok("Template should inserted after");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(3: This is date:)").offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btnTwo", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 < verifyVariable_cafe_1_1)
		.ok("Template should inserted before");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(".z-label:contains(4: This is date:)").offset().top,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("btnTwo", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0t < verifyVariable_cafe_1_1t)
		.ok("Template should inserted before");
});

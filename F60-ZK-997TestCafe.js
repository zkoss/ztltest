import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-997TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-997TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>
					1. Click on each of the \'Publish\' button. You should see two messages regarding to event receiving for each click.
				</div>
				<window	apply="org.zkoss.zktest.test2.F60_ZK_997_Composer">
					<div>
						Desktop: 
						<button id="dBtn" label="Publish" />
					</div>
					<div>
						Group: 
						<button id="gBtn" label="Publish" />
					</div>
					<div>
						Session: 
						<button id="sBtn" label="Publish" />
					</div>
					<div>
						Application: 
						<button id="aBtn" label="Publish" />
					</div>
					<div id="screen" />
				</window>
			</zk>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("dBtn", true).$n()))
		.wait(1000);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(Event received through )").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 2).ok("Has 2 mesasges");
	await t
		.click(Selector(() => zk.Desktop._dt.$f("gBtn", true).$n()))
		.wait(1000);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-label:contains(Event received through )").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 == 4).ok("Has 4 mesasges");
	await t
		.click(Selector(() => zk.Desktop._dt.$f("sBtn", true).$n()))
		.wait(1000);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-label:contains(Event received through )").length,
	)();
	await t.expect(verifyVariable_cafe_2_2 == 6).ok("Has 6 mesasges");
	await t
		.click(Selector(() => zk.Desktop._dt.$f("aBtn", true).$n()))
		.wait(1000);
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-label:contains(Event received through )").length,
	)();
	await t.expect(verifyVariable_cafe_3_3 == 8).ok("Has 8 mesasges");
});

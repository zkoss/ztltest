import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-691TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-691TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				<ol>
				<li>Click the create button</li>
				<li>Click the test button</li>
				<li>Then, you shall two message: "Correct" and another message starting with "Stub: [StubEvent onStub".</li>
				</ol>
				]]></html>
				<button id="btnOne" label="create"
				 onClick=\'Executions.createComponents("/test2/B60-ZK-691-inc.zul", null, null)\'/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(test)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-window-embedded:contains(Correct)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-window-embedded:contains(Stub:[StubEvent onStub)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_1_1)
		.ok(
			"shall see two message: 'Correct' and another message starting with 'Stub: [StubEvent onStub'.",
		);
});

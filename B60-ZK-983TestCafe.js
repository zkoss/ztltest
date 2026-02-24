import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-983TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-983TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Click the \'detach\' button, you should not see any error.</div>
				<combobutton id="cb" label="Combobutton" />
				<button id="btn" label="detach" onClick=\'cb.detach()\' />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-error")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq("#zk_err")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 || verifyVariable_cafe_1_1)
		.notOk("Should no js error");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(zk.Desktop._dt.$f("cb", true))[0],
			)(),
		)
		.notOk("Combobutton should be detached.");
});

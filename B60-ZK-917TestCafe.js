import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-917TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-917TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>
					Blue color should fill the entire region bound by red border.
				</div>
				<div id="div1" width="500px" height="500px" style="border: 1px solid #FF0000">
					<div id="div2" style="background: #333399" hflex="1" vflex="1" />
					<div style="position: absolute; top: 100px; left: 100px; border: 1px solid #00FF00;" 
						width="100px" height="100px" />
				</div>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div1", true)).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div1", true)).width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div2", true)).height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div2", true)).width(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 - verifyVariable_cafe_2_2 <= 2 &&
				verifyVariable_cafe_1_1 - verifyVariable_cafe_3_3 <= 2,
		)
		.ok("Blue color should fill the entire region bound by red border.");
});

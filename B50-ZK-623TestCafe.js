import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-623TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-623TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>	
					You should see the green area have height 400px, no larger.
				</div>
				<vbox id="vbox" height="400px" width="200px" style="background-color:green">
					<div id="div1" vflex="min">
						<div height="200px" style="background-color:blue">Div 1</div>
					</div>
					<div id="div2" vflex="1" width="100px" style="background-color:red">
						Div 2
					</div>
				</vbox>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("vbox", true).$n()).height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 400)
		.ok("the height of vbox should equal to 400");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-598TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-598TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript>
					Object[] o = new Object[50];
				</zscript>
				<div>
					You should see the red Div occupy the rest of height from the green area.
				</div>
				<div width="500px" height="500px" style="background-color:green">
					<div id="div0" vflex="1" width="400px">
						<div id="div1">
							<listbox rows="7">
								<listitem label="x" forEach="\${o}" />
							</listbox>
						</div>
						<div id="div2" vflex="1" hflex="true" style="background-color:red">
							Div
						</div>
					</div>
				</div>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div0", true).$n()).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div1", true).$n()).height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("div2", true).$n()).height(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 ==
				verifyVariable_cafe_1_1 + verifyVariable_cafe_2_2,
		)
		.ok("two inner div should full-fill the outer div");
});

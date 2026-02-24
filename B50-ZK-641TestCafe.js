import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-641TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-641TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<borderlayout>
					<west>
						<label id="lbOne" value="Some long text on the left" />
					</west>
					<center style="color: red; font-weight: bold">
						<div>
							<div>* IE only.</div>
							<div>* The text in West and East region should not wrap.</div>
							<label id="lbTwo" value="Single line" />
						</div>
					</center>
					<east>
						<label id="lbThree" value="Some text on the right" />
					</east>
				</borderlayout>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbThree", true).$n()).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbTwo", true).$n()).height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbTwo", true).$n()).height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbOne", true).$n()).height(),
	)();
	await t
		.expect(
			verifyVariable_cafe_3_3 == verifyVariable_cafe_1_1 &&
				verifyVariable_cafe_0_0 == verifyVariable_cafe_1_1,
		)
		.ok("The three labels should be single line");
});

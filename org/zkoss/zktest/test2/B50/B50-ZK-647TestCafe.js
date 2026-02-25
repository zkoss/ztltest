import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-647TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-647TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div height="10px" />
				<div height="20px">Check whether all the style of the \'Test\' below are correct,</div>
				<div height="20px">color:#0000CC; font-family:"courier new","times new roman",""; font-size:30px;</div>
				<label id="lb" value=\'Test\'
					style=\'color:#0000CC; font-family:"courier new","times new roman",""; font-size:30px;\'/>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n()).height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 >= 30)
		.ok("the style of font-size should be applied");
});

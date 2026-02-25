import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-478TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-478TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>The Imagemap size should be 300px by 300px.</div>
				<imagemap id="imap" width="300px" height="300px" src="/test2/img/icon_browser.png" />
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("imap", true).$n("real")).outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("imap", true).$n("real")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 == 300 && verifyVariable_cafe_1_1 == 300,
		)
		.ok("the image size should be 300 x 300");
});

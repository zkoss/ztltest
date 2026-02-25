import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2099562TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2099562TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	If you can see the height of the progressmeter (not only 1px) in Opera, that is correct.
	<progressmeter width="100px" id="pm" value="0"/>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@progressmeter").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 >= 16).ok();
});

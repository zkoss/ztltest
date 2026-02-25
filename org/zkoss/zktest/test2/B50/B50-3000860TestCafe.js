import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3000860TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3000860TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<tabbox>
<tabs>
	<tab id="tab1"/>
	<tab label="tab2"/>
</tabs>
<tabpanels>
	<tabpanel/>
</tabpanels>
</tabbox>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("$tab1").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 16).ok();
});

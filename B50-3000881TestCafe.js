import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3000881TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3000881TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<hbox>
<tabbox>
	<tabs>
		<tab label="tab1" />
		<tab label="tab2" />
		<tab label="tab3" />
	</tabs>
	<tabpanels>
		<tabpanel />
		<tabpanel />
		<tabpanel />
	</tabpanels>
</tabbox>
</hbox>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@tabbox").outerWidth(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 5000).notOk();
});

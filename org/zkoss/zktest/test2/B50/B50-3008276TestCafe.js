import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3008276TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3008276TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<listbox>
<listhead>
<listheader hflex="1"/>
</listhead>
</listbox>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-modal-mask")[0])())
		.notOk();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1829TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1829TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window apply="org.zkoss.zktest.test2.B70_ZK_1829" width="300px" border="normal">
	Should not show any error message.
</window>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});

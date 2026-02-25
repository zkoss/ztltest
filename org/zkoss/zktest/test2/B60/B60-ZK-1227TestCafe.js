import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1227TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1227TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    Should not see any error message.<separator/>
                    <decimalbox value="1111.112" locale="pt" format="#.##0,0##"/>
                  </zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see any error message.");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1518TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1518TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Should not see any error message showed.
	<decimalbox id="dbx" />
	<zscript><![CDATA[
		dbx.setLocale(java.util.Locale.GERMAN);
		dbx.setFormat("#,##0.0###");
		dbx.setValue(new java.math.BigDecimal(123456.1234));
	]]></zscript>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see any error message.");
});

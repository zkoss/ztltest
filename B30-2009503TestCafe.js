import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2009503TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2009503TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	1.Type "May/02/2008" into datebox , if no error , the bug fixed.
	<separator />
	format="MMM/dd/yyyy".<datebox  format="MMM/dd/yyyy"/>	
</zk>`,
	);
	await t.typeText(
		Selector(() => zk.Widget.$(jq("@datebox")).$n("real")),
		ztl.normalizeText("May/02/2008"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(() => !!jq('@window[title="ZK Test"]')[0])(),
		)
		.notOk();
});

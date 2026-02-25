import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1712TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1712TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Open the calendar, click next month arrow button, should see input value keep blank.
	<datebox width="150px" constraint="no future" />
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-datebox")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Widget.$(jq(".z-datebox")).$n("pp")).find(".z-calendar"),
			).$n("right"),
		),
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should see input value keep blank.");
});

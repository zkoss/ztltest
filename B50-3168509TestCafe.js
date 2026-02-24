import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3168509TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3168509TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the datebox button to open the Calendar.</li>
			<li>Select 1/1/2001. If you see a date value other than 01/01/2001, it\'s a bug.</li>
			<li>Refresh the page and select 1/2/2001. You should see 01/02/2001. Otherwise it\'s a bug.</li>
		</ol>
	]]></html>
	<datebox id="db" format="MM/dd/yyyy" text="12/31/2000" />
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected").next()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("01/01/2001"));
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected").next()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("01/02/2001"));
});

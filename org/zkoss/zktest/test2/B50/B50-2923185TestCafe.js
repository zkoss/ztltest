import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2923185TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2923185TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
      <zk>
      1. Click the datebox button to open the Calendar
      <separator/>
      2. the textbox inside the Calendar popup should be the current hour and min (same with the datebox above). If not, it\'s error.
      <separator/>
      <datebox id="db" cols="20" locale="en_US" format="yyyy/MM/dd HH:mm" onCreate="self.value = new Date()"/>
      </zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db", true).$n("real").value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(zk.Desktop._dt.$f("db", true).$n("pp")).find(
								".z-timebox",
							),
						).$n("real").value,
				)(),
			),
			"the time in datebox should equalt to the time in child timebox",
		);
});

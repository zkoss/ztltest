import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2829547TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2829547TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<window title="Timebox Bug test" border="normal">
				1.Please click the Up/Down icon of the first timebox.
				<separator/>
				2.And then click the Up/Down icon of the second timebox.
				<separator/>
				3.Click the "Run Report" to see the result.
			<zscript>
				Date now = new Date();
				void showValues() {
					if (startTime.getValue().getTime() == now.getTime()) {
						alert("Error! This is a bug!");
					} else if ( endTime.getValue().getTime() == now.getTime()) {
						alert("Error! This is a bug!");
					} else {
						alert("Correct! The bug is fixed!");
					}
				}
			</zscript>
				<timebox id="startTime" value="\${now}" />
				<timebox id="endTime" value="\${now}" />
				<button id="runReport" label="Run Report" onClick="showValues()"/>
			</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$("$startTime").$n("btn-up")));
	await ClientFunction(() => {
		zk.Widget.$("$startTime").$n("real").focus();
	})();
	await t.pressKey("tab");
	await t.click(Selector(() => zk.Widget.$("$endTime").$n("btn-up")));
	await ClientFunction(() => {
		zk.Widget.$("$endTime").$n("real").focus();
	})();
	await t.pressKey("tab");
	await t.click(Selector(() => jq("$runReport")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-highlighted .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Correct! The bug is fixed!"));
	await t.click(Selector(() => jq("$btn1")[0]));
});

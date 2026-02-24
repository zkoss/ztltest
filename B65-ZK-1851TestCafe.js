import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1851TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1851TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<zk>
	<vlayout>
		<span>the Spinner translated a value to NAN, this should not happen after fix</span>
		<span>1. input a value</span>
		<span>2. blur the widget (-> it will format to e.g. $1)</span>
		<span>3. increase the value again using the spinner button</span>
		<hlayout>
			Spinner <spinner format="$#,##0.##"/>
		</hlayout>
		<hlayout>
			DoubleSpinner <doublespinner step="0.5" format="$#,##0.##"/>
		</hlayout>
	</vlayout>
</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-spinner")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t.expect("true").ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("btn-up")));
	await ztl.waitResponse(t);
	await t.expect("true").ok();
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-doublespinner")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-doublespinner")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t.expect("true").ok();
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-doublespinner")).$n("btn-up")),
	);
	await ztl.waitResponse(t);
	await t.expect("true").ok();
});

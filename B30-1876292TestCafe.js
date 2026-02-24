import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1876292TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1876292TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If I try to type wrong value and then click reset button, the first time
			it reset wrong value, but after typing wrong value the second time,
			cb1.value = null refuses to reset wrong value.
			
			Or after loading the page and resetting blank combobox or with right value,
			and then type a wrong value, it refuses to reset.</n:p>
				<vbox>
				<combobox id="cb1" constraint="strict"/>
				<zscript>
				cb1.appendItem("aaa").value = "111";
				cb1.appendItem("ccc").value = "333";
				</zscript>
				<button id="reset" label="reset" onClick="cb1.value = null;"/>
				</vbox>
			</zk>`,
	);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq(".z-combobox")).$n("real")).focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Widget.$(jq(".z-combobox")).$n("real")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("a a a");
	await t.pressKey("tab");
	await t.click(Selector(() => zk.Desktop._dt.$f("reset", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});

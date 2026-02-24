import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1892396TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1892396TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Clone test">
	<vbox>
<html><![CDATA[
Steps:<br/>
1. Type "mm" to the first textbox<br/>
2. Type "kk" to the second textbox, and you shall see "kk" is shown instead of "mm". 
]]></html>

	<label style="background:blue;color:white;" id="l"/>
	<textbox id="t1" onChange="l.value = self.value"/>
	</vbox>
	<zscript>
	Textbox t2 = t1.clone();
	t2.setId("t2");
	t2.setParent(t1.parent);
	</zscript>
</window>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("t1", true).focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("t1", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("t1", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("m m");
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("l", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("mm"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("t2", true).focus();
	})();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("t2", true).$n()),
		ztl.normalizeText("kk"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("l", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("kk"));
});

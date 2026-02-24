import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2997037TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2997037TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
<li>Press "setLong" button. You shall see 9223372036854775807 show in the longbox.</li>
<li>In the longbox, change the last digit from 7 to 8, so the number become 9223372036854775808 and Tab away.</li>
<li>You shall see pop errorbox "Out of range(-9223372036854775808 - 9223372036854775807)"</li>
<li>In the longbox, add before the first digit with a negative sign, so the number become -9223372036854775808 and Tab away.</li>
<li>You shall NOT see any errorbox</li>
<li>In the longbox, change the last digit from 8 to 9, so the number become -9223372036854775809 and Tab away.</li>
<li>You shall see pop errorbox "Out of range(-9223372036854775808 - 9223372036854775807)"</li>
<li>done</li>
</ol>
]]>
</html>
<vbox>
longbox:<longbox id="longbx" width="300px"/>
<button id="btn" label="setLong" onClick="longbx.setValue(new Long(9223372036854775807L))"/>
</vbox>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-longbox").val())(),
			),
		)
		.eql(ztl.normalizeText("9223372036854775807"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().focus();
	})();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().value = "9223372036854775808";
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-longbox").val())(),
			),
		)
		.eql(ztl.normalizeText("9223372036854775808"));
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().focus();
	})();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().value = "-9223372036854775808";
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-longbox").val())(),
			),
		)
		.eql(ztl.normalizeText("-9223372036854775808"));
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().focus();
	})();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("longbx", true).$n().value = "-9223372036854775809";
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-longbox").val())(),
			),
		)
		.eql(ztl.normalizeText("-9223372036854775809"));
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});

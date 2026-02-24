import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1778258TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1778258TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c"?>
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>It\'s true, you should see the image after you click the button.</n:p>
			<window id="w1" title="Foo">
			<button id="btn1" label="click me"/>
			<vbox id="w2" fulfill="btn1.onClick">
			<div style="padding: 10px; background:\n			url(\${c:encodeURL(\'/img/battery.gif\')});">
			ABCD
			</div>
			</vbox>
			</window>
			</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@box @div")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@box @div")[0])()).ok();
});

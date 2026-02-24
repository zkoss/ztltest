import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3039364TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3039364TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html><![CDATA[
<ul>
 <li>Click the "click" button, and a popup shall show up (IE).</li>
 <li>Click the "200px" button to enlarge the popup.</li>
 <li>Click the "100px" button to shrink the popup.</li>
</ul>
]]></html>
<popup id="pop" width="100px" height="100px">
<button label="100px" onClick=\'self.parent.height = "100px"\' />
<button label="200px" onClick=\'self.parent.height = "200px"\' />
</popup>
<button label="click" onClick="pop.open(self);" />
<separator height="100px" />
<listbox mold="select" width="300px" />
</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="click"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("pop", true)).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq('@button[label="200px"]')[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("pop", true)).outerHeight(),
				)(),
			),
		)
		.eql(ztl.normalizeText("200"));
	await t.click(Selector(() => jq('@button[label="100px"]')[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("pop", true)).outerHeight(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100"));
});

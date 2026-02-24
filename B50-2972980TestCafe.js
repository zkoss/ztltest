import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2972980TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2972980TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html><![CDATA[
<ol>
<li>Click the "add listener" button first</li>
<li>Then click "Click Me", and then you shall see a "onClick" dialog shown up</li>
</ol>
]]></html>
	<div id="d" style="border:1px solid blue">Click Me</div>
	<button label="add listener" onClick=\'d.setWidgetListener("onClick", "jq.alert(event.name)")\'/>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.ok();
});

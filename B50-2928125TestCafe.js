import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2928125TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2928125TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
	<html><![CDATA[
	<ul>
		<li>Click the add/remove button first, and then click the test button.
		You shall see a modal window.</li>
		<li>Then, do it again. You shall see nothing</li>
	</ul>
	]]></html>
	<zscript>
	EventListener listener;
	</zscript>
	<button label="add/remove listener">
		<attribute name="onClick"><![CDATA[
	if (listener != null) {
		target.removeEventListener("onClick", listener);
		listener = null;
	} else {
		target.addEventListener("onClick", listener = new EventListener() {
			public void onEvent(Event evt) {
				alert("listener added");
			}
		});
	}
		]]></attribute>
	</button>
	<button id="target" label="test"/>
</window>`,
	);
	await t.click(
		Selector(() => jq('@button[label="add/remove listener"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$target")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$btn1")[0])()).ok();
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq('@button[label="add/remove listener"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$target")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$btn1")[0])()).notOk();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z30-focusTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-focusTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of focus">
<html><![CDATA[
<ol>
<li>Click "Try 1" and the following window shall become modal
and the focus remains on the first textbox</li>
<li>Click "Restore to embedded"</li>
<li>Click "Try 2\' the focus shall remains on the second modal</li>\n</ol>\n]]></html>\n	<window id="w" title="Window 1" border="normal" width="300px">\n		<textbox id="t1" value="First"/>\n		<textbox id="t2" value="Second"/>\n		<button label="Restore to embedded" onClick="w.doEmbedded()"/>\n	<button id="tb1" label="Try 1" onClick="t1.focus();w.doModal()"/>\n	<button id="tb2" label="Try 2" onClick="t2.focus();w.doModal()"/>\n	</window>\n</window>`,
	);
	await t.click(Selector(() => jq("$tb1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("t1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => zk.currentFocus.id)()),
		);
	await t.click(
		Selector(() => jq("$tb2")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("t2"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => zk.currentFocus.id)()),
		);
});

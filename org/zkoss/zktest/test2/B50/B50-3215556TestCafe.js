import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3215556TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3215556TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
	       <ol>
	       		<li>IE only</li>
	      	 	<li>Click maximal icon of the panel.</li>
				<li>Click close icon of the panel.</li>
				<li>It shall not js error happen.</li>
			</ol>
	]]></html>
	<portallayout maximizedMode="whole">
		<portalchildren>
			<panel maximizable="true" closable="true">
				<caption>aaa</caption>
				<panelchildren>
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-panel")).$n("max")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-panel")).$n("close")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

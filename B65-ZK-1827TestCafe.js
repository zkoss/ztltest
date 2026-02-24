import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1827TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1827TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
	Click "test" button, should not see JS Error showed.
	<tabbox id="tabbox">
		<attribute name="onEcho"><![CDATA[
			tabbox.invalidate();
		]]></attribute>
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" />
			<tab id="tab2" label="Tab 2" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel id="panel1">
				<attribute name="onCreate"><![CDATA[
					HtmlNativeComponent table = new HtmlNativeComponent("table", "<tbody>", "</tbody>");
					HtmlNativeComponent tr = new HtmlNativeComponent("tr");
					HtmlNativeComponent td = new HtmlNativeComponent("td");
					Window win = new Window();
					win.setTitle("window inside native");
					win.setVflex("true");
					win.setHflex("true");
					td.appendChild(win);
					tr.appendChild(td);
					table.appendChild(tr);
					panel1.appendChild(table);
				]]></attribute>
				<button label="test">
					<attribute name="onClick"><![CDATA[
						tab2.setSelected(true);
						tabbox.invalidate();
						Events.echoEvent("onEcho", tabbox, null);
					]]></attribute>
				</button>
			</tabpanel>
			<tabpanel>test</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(test)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});

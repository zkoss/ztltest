import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2559TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2559TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2559.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jan 28, 2015 12:51:01 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
		public void addColumn(Columns parent, String label, String width) {
			Column col = new Column(label);
			col.setWidth(width);
			parent.appendChild(col);
		}
		public void addAuxheader(Auxhead parent, String label, int colSpan) {
			Auxheader auxheader = new Auxheader(label);
			auxheader.setColspan(colSpan);
			parent.appendChild(auxheader);
		}
	]]></zscript>
	<label multiline="true">
	1. click grid tab
	2. you should not see js error
	</label>
	<tabbox id="tb">
		<tabs>
			<tab label="start"/>
			<tab label="grid">
				<attribute name="onClick"><![CDATA[
				    Auxhead auxhead1 = new Auxhead();
				    gr.appendChild(auxhead1);
				    addAuxheader(auxhead1, "", 1);
				    addAuxheader(auxhead1, "AH 1.1", 1);
				    addAuxheader(auxhead1, "AH 1.2", 1);
				    
				    addColumn(cols, "AAA", "160px");
				    addColumn(cols, "BBB", "80px");
				    addColumn(cols, "CCC", "80px");
				]]></attribute>
			</tab>
			<tab label="other"/>
		</tabs>
		<tabpanels>
			<tabpanel>start content</tabpanel>
			<tabpanel>
				<grid id="gr" hflex="min">
					<columns id="cols" sizable="true">
					</columns>
					<rows>
						<row><label value="aaa value"/><label value="bbb value"/><label value="ccc value"/></row>
						<row><label value="aaa value"/><label value="bbb value"/><label value="ccc value"/></row>
						<row><label value="aaa value"/><label value="bbb value"/><label value="ccc value"/></row>
					</rows>
				</grid>
			</tabpanel>
			<tabpanel>other content</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-tab").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-error").is(":visible"))())
		.notOk();
});

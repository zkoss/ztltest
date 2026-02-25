import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2558TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2558TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2558.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jan 28, 2015 11:00:25 AM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. click grid tab
2. you should not see js error
</label>
	<tabbox id="tb">
		<tabs>
			<tab label="start"/>
			<tab label="grid">
				<attribute name="onClick"><![CDATA[
 					Columns cols = new Columns();
 					gr.appendChild(cols);
					cols.appendChild(new Column("AAA"));
					cols.appendChild(new Column("BBB"));
					cols.appendChild(new Column("CCC"));
					fr.setColumns(1);
				]]></attribute>
			</tab>
			<tab label="other"/>
		</tabs>
		<tabpanels>
			<tabpanel>start content</tabpanel>
			<tabpanel>
				<grid id="gr">
					<frozen id="fr" columns="0"/>
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

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2088479TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2088479TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2088479.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Sep  3 11:19:01 TST 2008, Created by Flyworld
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>	
<vbox>
<label> 1.Click on the accordion tabbox, it shouldn\'t be
dissected.</label>
</vbox>
<tabbox width="400px" orient="vertical">
<tabs width="60px">
<tab label="Tab 1"/>
<tab label="Tab 2" selected="true"/>
</tabs>
<tabpanels>
<tabpanel height="100px" style="background:yellow">This is panel
1</tabpanel>
<tabpanel height="100px" style="background:blue;overflow:auto">This is
panel 2
<div height="200px">---</div>The second panel
</tabpanel>
</tabpanels>
</tabbox>
<tabbox width="400px" mold="accordion">
<tabs>
<tab id="tab1" label="Tab 1"/>
<tab id="tab2" label="Tab 2" selected="true"/>
</tabs>
<tabpanels>
<tabpanel id="p1" height="100px" style="background:yellow">This is panel
1</tabpanel>
<tabpanel id="p2" height="100px" style="background:blue;overflow:auto">This is
panel 2
<div height="200px">---</div>The second panel
</tabpanel>
</tabpanels>
</tabbox>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$tab1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("$p1").find(".z-tabpanel-content").is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("$p2").find(".z-tabpanel-content").is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("$tab2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("$p2").find(".z-tabpanel-content").is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("$p1").find(".z-tabpanel-content").is(":visible"),
			)(),
		)
		.notOk();
});

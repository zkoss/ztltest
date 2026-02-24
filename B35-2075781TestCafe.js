import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2075781TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075781TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
F35-2002986.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Jun 26 19:11:57 TST 2008, Created by gracelin
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window>
	1. Press the &quot;add&quot; button, and see the new column of columnlayout is 50% of right remainder width.
	<separator/>
	2. Press the &quot;remove&quot; button, and see the column disappear.
	<separator />
	3. it shouldn\'t pop-up error window when click remove.

	<columnlayout id="cl">
		<columnchildren id="ch" width="200px" style="padding: 5px">
			<panel height="100px" title="column" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</columnchildren>
	</columnlayout>
	
<zscript>
	import org.zkoss.zkmax.zul.Columnchildren;
	import org.zkoss.zul.Spinner;
	
	Columnchildren[] cc = new Columnchildren[15];
	int count = 0;
	
	public void add() {
		if (count > 14) return;
		
		cc[count] = new Columnchildren();
        cc[count].setId("ch"+count);
		cc[count].setWidth("50%");
		cc[count].setParent(cl);
		
		Panel p = new Panel();
		p.setHeight("100px");
		p.setStyle("padding: 5px");
		p.setTitle("column " + count);
		p.setBorder("normal");
		
		
		Panelchildren pc = new Panelchildren();
		Label l = new Label("test");
		l.setParent(pc);
		pc.setParent(p);
		p.setParent(cc[count]);
		count++;
	}
	public void remove() {
		if (count > 0)
			cc[--count].detach();
	}
</zscript>

	<button id="add" label="add" onClick="add()" />
	<button id="remove" label="remove" onClick="remove()" />
</window>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$add")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$ch0")[0])()).ok();
	let w_cafe = await ClientFunction(() => jq("@columnlayout").width())();
	let w1_cafe = await ClientFunction(() => jq("$ch0").width())();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText((w_cafe - 200) / 2),
		ztl.normalizeText(w1_cafe),
		ztl.normalizeText("2"),
	);
	await t.click(Selector(() => jq("$remove")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$ch0")[0])()).notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

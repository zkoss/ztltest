import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2884058TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2884058TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2884058.zul

	Purpose:
		
	Description:
		
	History:
		Fri Oct 23 14:30:13 TST 2009, Created by sam

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<window>
<vbox>
<label>Error in calendar component in IE and Opera.</label>
<label>1.Click on datebox\'s icon, it will popop a Calendar</label>
<label>2.Compare these 2 Calendar, look the same is correct</label>
</vbox>
<hbox>
<datebox/>
<separator orient="vertical" width="50px"/>
<calendar/>
</hbox>
</window>`,
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	let html0_cafe = await ClientFunction(() =>
		jq(".z-calendar:eq(0)").text().replace(/\s/g, " "),
	)();
	let html1_cafe = await ClientFunction(() =>
		jq(".z-calendar:eq(1)").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(html1_cafe))
		.eql(ztl.normalizeText(html0_cafe));
});

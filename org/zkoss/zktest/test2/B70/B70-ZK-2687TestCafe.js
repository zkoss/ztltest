import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2687TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2687TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2687.zul

	Purpose:

	Description:

	History:
		Tue Jun  9 16:56:25 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click either chk or txt button
	2. it will scroll to bottom and show notification to corresponding component.
	</label>
	<div>
    	<button label="txt" onClick=\'Clients.scrollIntoView(txt);
    		Clients.showNotification("txt", txt);\' />
   		<button label="chk" onClick=\'Clients.scrollIntoView(chk);
   		Clients.showNotification("chk", chk);\' />
   	</div>
    <div height="300px" style="overflow:auto">
    	<vlayout spacing="30px">
            <div height="350px"></div>
            <textbox id="txt" />
            <checkbox id="chk" />
        </vlayout>
   </div>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let content_cafe = await ClientFunction(() =>
		jq(".z-notification-content").last().text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(content_cafe))
		.eql(ztl.normalizeText("txt"));
	await t.click(Selector(() => jq("@button")[1]));
	await ztl.waitResponse(t);
	content_cafe = await ClientFunction(() =>
		jq(".z-notification-content").last().text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(content_cafe))
		.eql(ztl.normalizeText("chk"));
});

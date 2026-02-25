import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2331TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2331TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2331.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 18, 2014  16:55:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<vbox>
	<div style="height: 1000px;">
		1. ensure that the content is large than viewport.
		<separator></separator>
		2. click combobox at the bottom. if popup overlaps the input, it\'s a bug. 
	</div>
	<groupbox>
		<panel style="height:400px">
			<panelchildren>
				<div style="height: 350px;"></div>
				<combobox id="cmbColor">
					<comboitem label="testA" height="25px"/>
					<comboitem label="testB" height="25px"/>
					<comboitem label="testC" height="25px"/>
					<comboitem label="testD" height="25px"/>
				</combobox>
			</panelchildren>
		</panel>
	</groupbox>
</vbox>`,
	);
	await t.click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-combobox-popup").height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@combobox").offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 + verifyVariable_cafe_1_1 <
				verifyVariable_cafe_2_2,
		)
		.ok("popup shouldn't overlap the input.");
});

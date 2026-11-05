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
	const comboboxTop = (await Selector(".z-combobox").boundingClientRect).top;
	const popup = Selector(".z-combobox-popup").addCustomDOMProperties({
		bottom: (el) => el.getBoundingClientRect().bottom,
	});
	await t
		.expect(popup.bottom)
		.lte(comboboxTop + 1, "the popup should not overlap the input");
});

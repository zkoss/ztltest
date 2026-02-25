import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2704TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2704TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2704.zul

	Purpose:

	Description:

	History:
		Tue, Jun 9, 2015 14:30:29 PM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
		ListModelList locales = new ListModelList();

		public void loadOnDemand(OpenEvent event) {
			if(event.isOpen()) {
				List allLocales = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
				allLocales.removeAll(locales.getSelection());
				locales.addAll(allLocales);
			} else {
				//onOpen false is never called
				locales.retainAll(locales.getSelection());
			}
		}
	]]></zscript>
	<label multiline="true">
    	1. click button to open combobox and the combobox won\'t immediately close
	</label>
	<combobox model="\${locales}" onOpen=\'loadOnDemand(event)\'/>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	await t.wait(500);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-combobox-popup")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-combobox-popup").height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_1_1 > 10)
		.ok();
});

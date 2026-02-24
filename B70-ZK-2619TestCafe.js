import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2619TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2619TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2619.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Mar 03, 2015 11:00:06 AM, Created by JamesChu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click two buttons separately
	2. both errorbox will show up
	</label>
	<button label="Wrong value" onClick=\'throw new WrongValueException(textbox1, "error message");\'/>
	<textbox id="textbox1" multiline="true"/>
    <hlayout>
	    <button label="Wrong value" onClick=\'throw new WrongValueException(textbox2, "error message");\'/>
	    <textbox id="textbox2" multiline="true"/>
	</hlayout>
</zk>`,
	);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0])).wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-errorbox.z-errorbox-open").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2371TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2371TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<window mode="modal" closable="true">
	<grid>
	    <rows>
	        <row>
	            <vbox height="1800px">
	                <textbox width="400px" id="tb1Id" value="Please scroll down and click the Validate button"/>
	            </vbox>
	        </row>      
	        <row>
	            <textbox id="tb2Id" width="400px" constraint="no empty" />
	        </row>
	        <row>
	            <separator/>
	        </row>
	        <row>
	            <button label="Validate" width="150px" onClick="tb1Id.value = tb2Id.getValue()"/>
	        </row>
	    </rows>
	</grid>
</window>`,
	);
	await ClientFunction(() => {
		zk(jq("@button")).scrollIntoView();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@errorbox").is(":visible"))())
		.ok("it should show error box.");
});

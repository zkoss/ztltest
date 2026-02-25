import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2073438TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2073438TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<?page title="Welcome to ZK Demo"?>
	<!--
		index.zul {{IS_NOTE Purpose: Description: History: Thu May 11 17:24:33
		2006, Created by tomyeh }}IS_NOTE Copyright (C) 2006 Potix
		Corporation. All Rights Reserved. {{IS_RIGHT }}IS_RIGHT
	-->
<window title="Menu Demo" border="normal" id="win">
	<label id="label" value=\'Please scroll down to click the menu item "Dynamically Attribute" the window should not scroll top automatically\'/>
	<div height="1000px"> 123</div>
	<window>
		<menubar>
			<menu label="Dynamically Attribute" id="dynamic">
				<menupopup>
				</menupopup>
			</menu>
		</menubar>
	</window>
</window>`,
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$dynamic").focus();
	})();
	let top_cafe = await ClientFunction(() =>
		jq("document.body.parentNode").scrollTop(),
	)();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$dynamic")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("document.body.parentNode").scrollTop(),
	)();
	await t.expect(top_cafe == verifyVariable_cafe_0_0).ok();
});

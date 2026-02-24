import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2073428TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2073428TestCafe", async (t) => {
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
<window title="Menu Demo" border="normal" id="lbl">	
	<label  value=\'button "stone" should not be freezed after clicked and move the mouse away (it means the mouseover style should be removed)\'/>
	<menubar>		
		<menu label="stone" id="stone" />
	</menubar>	
</window>`,
	);
});

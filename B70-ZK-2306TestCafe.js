import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2306TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2306TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2306.zul

	Purpose:
		
	Description:
		
	History:
		Thu, May 22, 2014  4:09:59 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div height="1200px">scroll down to click the datebox and use keyboard to navigate the calendar with UP and DOWN, the browser\'s scrollbar won\'t be moved.</div>
	<datebox/>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	let scrollTop_cafe = await ClientFunction(() => jq("body").scrollTop())();
	await t.pressKey("down").pressKey("down").pressKey("up");
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("body").scrollTop(),
	)();
	await t
		.expect(scrollTop_cafe == verifyVariable_cafe_0_0)
		.ok("browser's scrollbar shouldn't move.");
});

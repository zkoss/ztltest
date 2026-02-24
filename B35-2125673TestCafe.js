import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2125673TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2125673TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2125673.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Sep 24 16:38:32     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
	Please click the "fruits" title, and then the groupbox should not be closed.
		<groupbox id="gb" width="300px" closable="false">
			<caption image="/test2/img/inet.png" label="fruits"/>
			<radiogroup onCheck="fruit.value = self.selectedItem.label">
				<radio label="Apple"/>
				<radio label="Orange"/>
				<radio label="Grape"/>
			</radiogroup>
		</groupbox>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@caption")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(zk.Widget.$(jq("@groupbox")).$n("cave"))[0],
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@groupbox")).$n("cave")).is(":visible"),
			)(),
		)
		.ok();
});

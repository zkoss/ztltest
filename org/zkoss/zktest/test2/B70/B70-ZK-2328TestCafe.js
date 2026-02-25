import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2328TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2328TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2328.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 16, 2014  4:55:12 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
You should not see the browser scroll to the end of the browser. (if yes, that\'s a bug)
	<div height="900px"></div>
	<vlayout>
		<listbox checkmark="true" id="listbox">
			<listhead>
				<listheader label="col 1" />
				<listheader label="col 2" />
			</listhead>
			<listgroup label="Listgroup"/>
			<listitem>
				<listcell label="row 1 cell 1" />
				<listcell label="row 1 cell 2" />
			</listitem>
			<listitem selected="true">
				<listcell label="Selected row 2 cell 1" />
				<listcell label="Selected row 2 cell 2" />
			</listitem>
			<listgroupfoot label="Listgroupfoot"/>
		</listbox>
		<button label="Multiple Selection" onClick="listbox.setMultiple(!listbox.isMultiple())" />
	</vlayout>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("body").scrollTop(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 0)
		.ok("scrolling shouldn't to be changed.");
});

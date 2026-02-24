import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2348TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2348TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2348.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 16, 2014  4:41:33 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	You should see only one listheader(auxheader), if you see two listheaders that\'s a bug
	<listbox width="200px">
		<listhead>
			<listheader hflex="1" />
			<listheader hflex="2" />
			<listheader hflex="1" />
		</listhead>
		<auxhead>
			<auxheader colspan="3">
				auxheader (listheaders hidden)
			</auxheader>
		</auxhead>
		<listitem>
			<listcell>hflex 1</listcell>
			<listcell>hflex 2</listcell>
			<listcell>hflex 1</listcell>
		</listitem>
		<listitem>
			<listcell>hflex 1</listcell>
			<listcell>hflex 2</listcell>
			<listcell>hflex 1</listcell>
		</listitem>
	</listbox>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => jq("@listhead").is(":visible"))())
		.notOk("listhead should be invisible");
});

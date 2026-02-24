import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2538TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2538TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2538.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Jan 20, 2015 11:24:48 AM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
		1. Open the page
		2. Mavigate to the last page
		3. Click the "Simulate content changed" button in the first row"\n		There should not be any JS error shown\n	</label>\n    <zscript><![CDATA[\n    List items = Collections.nCopies(50000, "test");\n    ]]></zscript>\n    <tree mold="paging" pageSize="2">\n        <treecols>\n            <treecol label="Column 1" />\n            <treecol label="Column 2" />\n        </treecols>\n        <treechildren>\n            <treeitem forEach="\${items}">\n                <treerow>\n                    <treecell label="\${forEachStatus.index}"/>\n                    <treecell>\n                        <button label="Simulate content changed (detach)">\n	                        <attribute name="onClick"><![CDATA[\n	                        Treerow row = (Treerow) self.parent.parent;\n	                        Treeitem item = row.getParent();\n	                        row.detach();\n	                        item.appendChild(row);\n                        ]]></attribute>\n                        </button>\n                    </treecell>\n                </treerow>\n            </treeitem>\n        </treechildren>\n    </tree>\n</zk>`,
	);
	await t.wait(5000);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button.z-paging-last")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-error").is(":visible"))())
		.notOk();
});

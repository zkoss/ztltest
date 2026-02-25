import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2206TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2206TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2206.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Mar 31, 2014  5:26:21 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<zscript>
Treechildren tc = new Treechildren();
tc.setId("abc");
</zscript>
You should not see any java exception and then 

<button label="Click this to see the log with a word \'true\'">
<attribute name="onClick">
tree.appendChild(tc);
Clients.evalJavaScript("zk.log(zk.Widget.$(\'$abc\') != null)");
</attribute>
</button>
<tree id="tree"/>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("true"), "the log with a word 'true'");
});

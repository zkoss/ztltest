import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1836TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1836TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1836.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 03, 2013 10:03:35 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk xmlns:n="native" xmlns:h="xhtml">
  If you can see the log with "&lt;/script>" three times, the bug is fixed.
  <script>
    var s = "&lt;/Script>";
    zk.log(s);
    </script>
  <n:script>
    var s = "&lt;/ScripT>";
    zk.log(s);
    </n:script>
  <h:script>
    var s = "&lt;/ScrIpt>";
    zk.log(s);
    </h:script>
</zk>`,
	);
	await t.wait(500);
	let v_cafe = await ClientFunction(() => jq("#zk_log").val())();
	await t
		.expect(ztl.normalizeText(v_cafe))
		.contains(
			ztl.normalizeText("</Script>"),
			"If you can see the log with '</script>' three times, the bug is fixed.",
		);
	await t
		.expect(ztl.normalizeText(v_cafe))
		.contains(
			ztl.normalizeText("</ScripT>"),
			"If you can see the log with '</script>' three times, the bug is fixed.",
		);
	await t
		.expect(ztl.normalizeText(v_cafe))
		.contains(
			ztl.normalizeText("</ScrIpt>"),
			"If you can see the log with '</script>' three times, the bug is fixed.",
		);
});

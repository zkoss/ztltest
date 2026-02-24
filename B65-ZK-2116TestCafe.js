import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-2116TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2116TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-2116.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Mar 28, 2014 12:12:36 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
If you can see this page without any JS error, that\'s correct.
<button>
	<attribute name="label">
		<![CDATA[ </script><script src=//a/e> ]]>
	</attribute>
</button>
<listbox>
<listitem>
<attribute name="label"><![CDATA[
</script ><script src=//a/e>
]]></attribute>
</listitem>
</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});

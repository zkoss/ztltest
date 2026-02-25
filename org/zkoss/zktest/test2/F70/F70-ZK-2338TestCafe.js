import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F70-ZK-2338TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F70-ZK-2338TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c"?>
<!--
F70-ZK-2338.zul

	Purpose:
		
	Description:
		
	History:
		Wed, July 2, 2014  12:41:04 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window>
	You should see four words "HelloWorld", "HelloWorld3", "HelloWorld34", "HelloWorld345".
	<separator/>
	
	<zscript>
	public class ABC{
		public String toString(){return "World";}
	}
	</zscript>
	<zscript>
 		ABC d = new ABC();
	</zscript>
	<label value="\${c:cat(\'Hello\', d)}"/><separator/>
	<label value="\${c:cat3(\'Hello\', d, 3)}"/><separator/>
	<label value="\${c:cat4(\'Hello\', d, 3, 4)}"/><separator/>
	<label value="\${c:cat5(\'Hello\', d, 3, 4, 5)}"/><separator/>
</window>`,
	);
	await t
		.expect(ztl.normalizeText("HelloWorld"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label").eq(1).html())(),
			),
		);
	await t
		.expect(ztl.normalizeText("HelloWorld3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label").eq(2).html())(),
			),
		);
	await t
		.expect(ztl.normalizeText("HelloWorld34"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label").eq(3).html())(),
			),
		);
	await t
		.expect(ztl.normalizeText("HelloWorld345"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label").eq(4).html())(),
			),
		);
});

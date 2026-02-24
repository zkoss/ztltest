import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2086093TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2086093TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<!--
Z30-listbox-0008.zul

{{IS_NOTE
Purpose:

Description:

History:
Thu Oct 27 21:18:02 2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
no metter click on checkbox, button or textbox. it should not show "selected" message below.
<listbox onSelect=\'inf.appendChild(new Label("selected"))\'>
	<listhead>
		<listheader label="Population"/>
		<listheader label="%"/>
	</listhead>
	<listitem value="A">
		<listcell><textbox id="t1" value="A. Graduate"/></listcell>
		<listcell label="20%"/>
	</listitem>
	<listitem value="B">
		<listcell><checkbox id="ch1" label="B. College"/></listcell>
		<listcell><button id="b1" label="23%"/></listcell>
	</listitem>
	<listitem value="C">
		<listcell label="C. High School"/>
		<listcell><textbox id="t2" cols="8" value="40%"/></listcell>
	</listitem>
</listbox>
      
<vlayout id="inf"/>
</zk>`,
	);
	await t.click(Selector(() => jq("$t1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq('@label[value="selected"]').is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("$t2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq('@label[value="selected"]').is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("ch1", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq('@label[value="selected"]').is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("$b1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq('@label[value="selected"]').is(":visible"),
			)(),
		)
		.notOk();
});

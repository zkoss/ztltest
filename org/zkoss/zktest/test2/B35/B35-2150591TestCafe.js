import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2150591TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2150591TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2150591.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct  7 11:02:50     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
<listbox id="lb" width="200px">
<listgroup label="Listgroup" id="lg"/>
<listitem label="Listitem"/>
<listgroupfoot id="lgf" label="Listgroupfoot"/>
<listgroup label="Listgroup" id="lg2"/>
<listitem label="Listitem"/>
</listbox>
<button id="but1" label="After click me, Listgroupfoot should be replaced" onClick=\'if (lgf != lb.getLastChild()) lb.insertBefore(lgf, null); else lb.insertBefore(lgf, lg2);\'/>
<button id="but2" label="After click me, Listgroup and Listgroupfoot should be removed" onClick=\'lg.detach(); lg2.detach();\'/>
<grid width="200px">
<rows id="rs">
<group label="Group" id="g"/>
<row><label value="Row"/></row>
<groupfoot id="gf" label="Groupfoot"/>
<group id="g2" label="Group" />
<row><label value="Row"/></row>
</rows>
</grid>
<button id="but3" label="After click me, Groupfoot should be replaced" onClick=\'if (gf != rs.getLastChild()) rs.insertBefore(gf, null); else rs.insertBefore(gf, g2);\'/>
<button id="but4" label="After click me, Group and Groupfoot should be removed" onClick=\'g.detach(); g2.detach();\'/>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$but1")[0]));
	await ztl.waitResponse(t);
	let id_cafe = await ClientFunction(
		() => zk.Widget.$(jq("$lb")).lastChild.id,
	)();
	await t.expect(ztl.normalizeText("lgf")).eql(ztl.normalizeText(id_cafe));
	await t.click(Selector(() => jq("$but2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listgroup")[0])())
		.notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-listgroupfoot")[0])())
		.notOk();
	await t.click(Selector(() => jq("$but3")[0]));
	await ztl.waitResponse(t);
	let id1_cafe = await ClientFunction(
		() => zk.Widget.$(jq("$rs")).lastChild.id,
	)();
	await t.expect(ztl.normalizeText("gf")).eql(ztl.normalizeText(id1_cafe));
	await t.click(Selector(() => jq("$but4")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-group")[0])()).notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-groupfoot")[0])())
		.notOk();
});

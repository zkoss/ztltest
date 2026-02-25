import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2356TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2356TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2356.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 16, 2014  3:09:33 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div>
		if you see the menupopup don\'t have the same height to the top when clicking on the three menus, that\'s a bug. 
	</div>
	<menubar>
		<menu label="menu1" >
			<menupopup onOpen="org.zkoss.lang.Threads.sleep(500);">
				<menuitem label="menu11"></menuitem>
				<menuitem label="menu12"></menuitem>
				<menuitem label="menu13"></menuitem>
				<menuitem label="menu14"></menuitem>
			</menupopup>
		</menu>
		<menu label="menu2">
			<menupopup onOpen="">
				<menuitem label="menu21"></menuitem>
				<menuitem label="menu22"></menuitem>
				<menuitem label="menu23"></menuitem>
				<menuitem label="menu24"></menuitem>
			</menupopup>
		</menu>
		<menu label="menu3">
			<menupopup>
				<menuitem label="menu31"></menuitem>
				<menuitem label="menu32"></menuitem>
				<menuitem label="menu33"></menuitem>
				<menuitem label="menu34"></menuitem>
			</menupopup>
		</menu>
	</menubar>
</zk>`,
	);
	await t.click(
		Selector(() => jq("@menu").first()[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let sTop_cafe = await ClientFunction(() =>
		jq("@menupopup").first().scrollTop(),
	)();
	await t.click(
		Selector(() => jq("@menu").first()[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@menu").eq(1)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@menupopup").eq(1).scrollTop(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(sTop_cafe),
			"menupopups should have same height of top.",
		);
	await t.click(
		Selector(() => jq("@menu").eq(1)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@menu").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@menupopup").eq(2).scrollTop(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(sTop_cafe),
			"menupopups should have same height of top.",
		);
});

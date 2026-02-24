import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2585234TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2585234TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2585234.zul

	Purpose:
		
	Description:
		
	History:
		Thu Feb 19 18:21:45     2009, Created by jumperchen

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript>
	import org.zkoss.zktest.util.*;
	LiveGroupRenderer renderer = new LiveGroupRenderer();
	</zscript>
	
	<zscript>
		String[][][] datas = new String[][][]{
			new String[][] {
				// Today
				new String[]{"1","[zk1 - Help] RE: Bandbox Autocomplete Problem","2008/11/18 10:16:27","16KB"},
				new String[]{"2","[zk1 - Help] RE: Bandbox Autocomplete Problem","2008/11/18 10:14:27","18KB"},
				new String[]{"3","[zk1 - Help] RE: Databinding with radiogroups","2008/11/18 09:47:27","12KB"},
				new String[]{"4","[zk1 - Help] RE: It\'s not possible to navigate a listbox\' ite","2008/11/18 09:35:27","12KB"},
				new String[]{"5","[zk1 - Help] RE: ZK problem in dynamic menu","2008/11/18 08:37:27","12KB"},				
				new String[]{"6","[zk1 - Help] RE: FileUpload","2008/11/18 08:27:57","14KB"},
				new String[]{"7","[zk1 - Help] RE: Datebox format","2008/11/18 06:27:31","11KB"},
				new String[]{"8","[zk1 - Help] RE: Datebox format","2008/11/18 06:17:22","12KB"},
				new String[]{"9","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"10","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"11","[zk1 - Help] FileUpload","2008/11/18 05:07:25","11KB"},
				new String[]{"12","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"13","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"14","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"15","[zk1 - General] RE: Opening more than one new	browser window","2008/11/18 04:44:17","12KB"},
				new String[]{"16","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/18 04:31:12","14KB"},
			},
			new String[][] {
				// Yesterday
				new String[]{"1","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:44:17","39KB"},
				new String[]{"2","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:42:17","35KB"},
				new String[]{"3","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 19:40:17","26KB"},
				new String[]{"4","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 18:14:17","27KB"},
				new String[]{"5","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 17:05:17","18KB"},
				new String[]{"6","[zk1 - General] RE: Opening more than one new browser window","2008/11/17 16:44:17","19KB"},
				new String[]{"7","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"8","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"9","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"10","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 13:31:12","14KB"},
				new String[]{"11","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"12","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"13","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 13:26:37","14KB"},
				new String[]{"14","[zk1 - Help] RE: Times_Series Chart help","2008/11/17 10:41:33","14KB"},	
				new String[]{"15","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/17 10:14:27","14KB"},
			},
			new String[][] {
				new String[]{"1","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"2","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"3","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/15 04:31:12","14KB"},
				new String[]{"4","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"5","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"6","[zk1 - Help] RE: Times_Series Chart help","2008/11/15 03:26:37","14KB"},
				new String[]{"7","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 12:41:33","14KB"},
				new String[]{"8","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"9","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"10","[zk1 - Help] RE: Times_Series Chart help","2008/11/14 02:41:33","14KB"},
				new String[]{"11","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"12","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"13","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
				new String[]{"14","[zk1 - Help] RE: SelectedItemConverter Question","2008/11/13 02:14:27","14KB"},
			}			
		};
		GroupsModel model = new SimpleGroupsModel(datas,new String[]{"Date: Today", "Date: Yesterday", "Date: Last Week"});
	</zscript>
	Please click the left icon of "Date: Today", than you should see the list of "Date: Yesterday" display correctly.
	<grid id="lb1" mold="paging" height="400px" model="&#36;{model}" rowRenderer="&#36;{renderer}">
	 	<columns sizable="true">
    	   <column width="80px" label="From"/>
	       <column label="Subject"/>
	       <column width="150px" label="Received"/>
	       <column width="50px" label="Size"/>
         </columns>
	</grid>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@group")).$n("img")));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let len_cafe = await ClientFunction(
		() => jq('.z-row:contains("2008/11/17")').length,
	)();
	await t.expect(ztl.normalizeText("15")).eql(ztl.normalizeText(len_cafe));
	let b_cafe = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(0).is(":visible"),
	)();
	await t.expect(b_cafe).ok();
	let b_cafet = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(1).is(":visible"),
	)();
	await t.expect(b_cafet).ok();
	let b_cafett = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(2).is(":visible"),
	)();
	await t.expect(b_cafett).ok();
	let b_cafettt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(3).is(":visible"),
	)();
	await t.expect(b_cafettt).ok();
	let b_cafetttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(4).is(":visible"),
	)();
	await t.expect(b_cafetttt).ok();
	let b_cafettttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(5).is(":visible"),
	)();
	await t.expect(b_cafettttt).ok();
	let b_cafetttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(6).is(":visible"),
	)();
	await t.expect(b_cafetttttt).ok();
	let b_cafettttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(7).is(":visible"),
	)();
	await t.expect(b_cafettttttt).ok();
	let b_cafetttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(8).is(":visible"),
	)();
	await t.expect(b_cafetttttttt).ok();
	let b_cafettttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(9).is(":visible"),
	)();
	await t.expect(b_cafettttttttt).ok();
	let b_cafetttttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(10).is(":visible"),
	)();
	await t.expect(b_cafetttttttttt).ok();
	let b_cafettttttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(11).is(":visible"),
	)();
	await t.expect(b_cafettttttttttt).ok();
	let b_cafetttttttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(12).is(":visible"),
	)();
	await t.expect(b_cafetttttttttttt).ok();
	let b_cafettttttttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(13).is(":visible"),
	)();
	await t.expect(b_cafettttttttttttt).ok();
	let b_cafetttttttttttttt = await ClientFunction(() =>
		jq('.z-row:contains("2008/11/17")').eq(14).is(":visible"),
	)();
	await t.expect(b_cafetttttttttttttt).ok();
});

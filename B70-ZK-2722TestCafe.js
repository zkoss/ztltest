import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2722TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2722TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

		<!--
B70-ZK-2722.zul

	Purpose:

	Description:

	History:
		Fri, May 29, 2015  11:30:29 PM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
			<zk>
				<zscript><![CDATA[
		ListModelList model = new ListModelList();

		model.add("a");
		//model.add("b");

		public void clear(){
			grid.getModel().clear();
		}
	]]>
				</zscript>
				<label multiline="true">
					1. click \'clear\' and you should see "a" disappeared with no Exceptions
				</label>
				<custom-attributes org.zkoss.zul.grid.rod = "true"/>
				<grid id="grid" model="\${model}" mold="paging" autopaging="true" pageSize="3">
					<template name="model">
						<row>
							<label value="\${each}" />
						</row>
					</template>
				</grid>
				<button onClick="clear()">clear</button>
			</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText("a"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-messagebox-error").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});

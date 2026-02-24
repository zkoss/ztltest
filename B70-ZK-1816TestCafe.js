import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1816TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1816TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

		<!--
B70-ZK-1816.zul

	Purpose:

	Description:

	History:
		Mon Jun  1 11:50:25 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
			<zk>
				<label multiline="true">
					1. hide 1st listheader
					2. sort 2nd listheader
					3. 1st listheader shouldn\'t appear
				</label>
				<listbox id="box">
					<listhead menupopup="auto">
						<listheader label="Name" sort="auto" />
						<listheader label="Gender" sort="auto" />
						<listheader label="Age"  sort="auto"/>
						<listheader label="Description"  sort="auto"/>
					</listhead>
					<listitem>
						<listcell label="Mary" />
						<listcell label="FEMALE" />
						<listcell label="18" />
						<listcell label="A young lady." />
					</listitem>
					<listitem>
						<listcell label="Emma" />
						<listcell label="FEMALE" />
						<listcell label="19" />
						<listcell label="A young lady." />
					</listitem>
					<listitem>
						<listcell label="John" />
						<listcell label="MALE" />
						<listcell label="20" />
						<listcell label="A college student." />
					</listitem>
					<listitem>
						<listcell label="Jane" />
						<listcell label="FEMALE" />
						<listcell label="32" />
						<listcell label="A remarkable artist." />
					</listitem>
					<listitem>
						<listcell label="Judy" />
						<listcell label="FEMALE" />
						<listcell label="34" />
						<listcell label="A remarkable artist." />
					</listitem>
					<listitem>
						<listcell label="Henry" />
						<listcell label="MALE" />
						<listcell label="29" />
						<listcell label="A graduate." />
					</listitem>
					<listitem>
						<listcell label="Howard" />
						<listcell label="MALE" />
						<listcell label="21" />
						<listcell label="A graduate." />
					</listitem>
				</listbox>
			</zk>`,
	);
	await t
		.hover(Selector(() => jq(".z-listheader").eq(0)[0]))
		.click(Selector(() => jq(".z-listheader-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem-content").eq(4)[0]));
	await ztl.waitResponse(t);
	await t
		.hover(Selector(() => jq(".z-listheader").eq(1)[0]))
		.click(Selector(() => jq(".z-listheader").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-listheader").eq(0)).$n("hdfaker"),
					).css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("collapse"));
});

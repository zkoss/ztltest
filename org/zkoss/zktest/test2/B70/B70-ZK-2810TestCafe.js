import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2810TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2810TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2810.zul

	Purpose:
		
	Description:
		
	History:
		Wed Jul  8 10:59:41 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<div>
	<label multiline="true">
	1. switch between each tab
	2. the height of tabpanel should adjust with the content
	</label>
    <tabbox orient="left" width="300px">
        <tabs width="100px">
            <tab label="Tab short" />
            <tab label="Tab long" />
            <tab label="Tab even longer" />
        </tabs>
        <tabpanels>
            <tabpanel>
            	<div height="200px" style="background-color: red;"/>
            </tabpanel>
            <tabpanel>
            	<div height="400px" style="background-color: green;"/>
            </tabpanel>
            <tabpanel>
            	<div height="600px" style="background-color: blue;"/>
            </tabpanel>
        </tabpanels>
    </tabbox>
</div>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tabpanel > .z-div").eq(0).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").eq(0).height())(),
			),
		);
	await t.click(Selector(() => jq(".z-tab").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tabpanel > .z-div").eq(1).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").eq(1).height())(),
			),
		);
	await t.click(Selector(() => jq(".z-tab").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tabpanel > .z-div").eq(2).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").eq(2).height())(),
			),
		);
	await t.click(Selector(() => jq(".z-tab").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tabpanel > .z-div").eq(0).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").eq(0).height())(),
			),
		);
});

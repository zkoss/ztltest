import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1905TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1905TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1905.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Aug 30, 2013  9:53:41 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript>
	List lst = Arrays.asList(new String[] { "first", "second", "third" });
	ListModel model = new ListModelList(lst);
	</zscript>
		<label multiline="true">
		1. Focus into the chosenbox the "--------" text should be removed.
		2. Focus out of the chosenbox the "-------" text should appear again.
		3. Focus in and select an item in the dropdown list.
		4. Remove that item you selected by clicking the close icon, and the "-------" text should not appear there (when focused)
		</label>
		<chosenbox id="cbx" width="500px" model="\${model}" emptyMessage="------------------"/>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-chosenbox")).$n("inp").value,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("-"),
			"the '--------' text should be removed",
		);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-chosenbox")).$n("inp").value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("-"),
			"the '--------' text should appear again",
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-delete")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-chosenbox")).$n("inp").value,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("-"),
			"the '--------' text should not appear",
		);
});

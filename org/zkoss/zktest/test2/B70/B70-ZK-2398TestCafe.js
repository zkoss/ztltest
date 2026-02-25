import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2398TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2398TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2398.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Aug 12, 2014  3:51:43 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. Click on tree column to sort.
	2. It is bug if not see sort icon on tree column.
	</label>
	<tree id="tree" rows="5">
		<treecols sizable="true">
			<treecol label="Name" sort="auto" />
			<treecol label="Description" sort="auto" />
		</treecols>
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
					<treecell label="Item 1 description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item 2" />
					<treecell label="Item 2 description" />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 2.1" />
						</treerow>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 2.2" />
							<treecell
								label="Item 2.2 is something who cares" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
		</treechildren>
		<treefoot>
			<treefooter label="Count" />
			<treefooter label="Summary" />
		</treefoot>
	</tree>
</zk>`,
	);
	await t.click(Selector(() => jq("@treecol").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-icon-caret-up")[0])())
		.ok("we should see the caret-up icon.");
	await t.click(Selector(() => jq("@treecol").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@treecol").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-icon-caret-up")[0])())
		.ok("we should see the caret-up icon.");
});

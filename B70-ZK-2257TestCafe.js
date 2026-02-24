import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2257TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2257TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2257.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Apr 17, 2014  9:46:45 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. click the button "First click can see the bug"
2. The pupop should open at bottom of the button.
</label>
		<window id="dialog" mode="modal" border="normal" width="600px"
			height="400px" >
			<space height="200px" />
			<button sclass="inactiveButton" label="No issue"
				onClick=\'serviceInvoicePop.open(self,"after_start")\'/>
			<button id="target" label="First click can see the bug"
				onClick=\'serviceWorkspace.open(self,"after_start")\'	/>
			<popup id="serviceInvoicePop" style="border: 1px solid #86A4BE;" width="300px">
				<listbox id="invoiceBox" rows="10">
					<listhead>
						<listheader>
							<vlayout>
								<space height="3px" />
								<textbox instant="true"
									width="80%" />
								<label value="labels.service.addmodify.label.inter" />
							</vlayout>
						</listheader>
					</listhead>
					<template name="model" var="each">
						<listitem>
							<listcell label="\${each}" value="\${each}" />
						</listitem>
					</template>
				</listbox>
			</popup>

			<popup id="serviceWorkspace" style="border: 1px solid #86A4BE;" width="300px">
				<listbox id="workspaceBox" rows="10">
					<listhead>
						<listheader>
							<vlayout>
								<space height="3px" />
								<textbox instant="true"
									width="80%" />
								<label value="Service label" />
							</vlayout>
						</listheader>
					</listhead>
					<template name="model" var="each">
						<listitem>
							<listcell label="\${each}" value="\${each}" />
						</listitem>
					</template>
				</listbox>
			</popup>
			<zscript><![CDATA[
				ListModelList model60 = new ListModelList();			                  
				for (int i = 0; i<60 ;i ++){
					model60.add("Space "+i);
				}
				workspaceBox.setModel(model60);
				
				ListModelList model3 = new ListModelList();
				model3.add("Invoice a");
				model3.add("Invoice b");
				model3.add("Invoice c");
				invoiceBox.setModel(model3);
			]]></zscript>

		</window>
</zk>`,
	);
	await t.click(Selector(() => jq("$target")[0]));
	await ztl.waitResponse(t);
	let bBottom_cafe_0 = await ClientFunction(
		() => jq("$target").offset().top,
	)();
	let bBottom_cafe_1 = await ClientFunction(() => jq("$target").height())();
	let bBottom_cafe = bBottom_cafe_0 + bBottom_cafe_1;
	let totalHeight_cafe_2 = await ClientFunction(() =>
		jq("@popup").height(),
	)();
	let totalHeight_cafe = bBottom_cafe + totalHeight_cafe_2;
	let windowHeight_cafe = parseInt(
		await ClientFunction(
			() =>
				window.innerHeight |
				Math.max(
					document.body.clientHeight,
					document.documentElement.clientHeight,
				),
		)(),
	);
	let answer_cafe_3 = await ClientFunction(() => jq("@popup").offset().top)();
	let answer_cafe =
		bBottom_cafe < answer_cafe_3 || totalHeight_cafe > windowHeight_cafe;
	await t
		.expect(answer_cafe)
		.ok("Popup should be shown start from the bottom of button.");
});

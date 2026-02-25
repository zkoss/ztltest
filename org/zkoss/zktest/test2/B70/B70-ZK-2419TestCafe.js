import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2419TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2419TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2419.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Sep 03, 2014  1:54:33 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
Please drag the silder to 3.5 value, and it should stay at 3.5 value and its tooltip should be 3.5 as well
<zscript>
public class SliderDoubleVM {
	double potentialRisk = 2.0;
	public void setPotentialRisk(double potentialRisk) {
		this.potentialRisk = potentialRisk; 
	}
	public double getPotentialRisk() {
		return potentialRisk;
	}
}
</zscript>
<div apply="org.zkoss.bind.BindComposer"
	viewModel="@id(\'vm\')@init(\'SliderDoubleVM\')">
	<slider mode="decimal" maxpos="5.0" step="0.5"
		curpos="@bind(vm.potentialRisk)" />
	<label value="@load(vm.potentialRisk)"></label>
</div>
</zk>`,
	);
	await t.hover(Selector(() => jq(".z-slider-button")[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-slider-button")[0]),
		54,
		0,
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label").last().text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("3.5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-slider-button").attr("title"),
				)(),
			),
		)
		.eql(ztl.normalizeText("3.5"));
});

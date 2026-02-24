import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-361TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-361TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
			<?component name="include" extends="include" mode="defer" ?>
			<!--
			B50-ZK-361.zul
			
				Purpose:
					
				Description:
					
				History:
					Fri Aug 26 14:26:01 TST 2011, Created by jumperchen
			
			Copyright (C) 2011 Potix Corporation. All Rights Reserved.
			
			-->
			<window title="Grid with Group feature" border="normal">
				<html><![CDATA[  
					Please click the fill button, then you should not see any Javascript error.
				]]></html>
				
				<button id="btn" label="fill"/>
				<portallayout>
					<portalchildren width="50%" fulfill="btn.onClick">
						<panel height="200px" title="Popup">
							<panelchildren>
								<include src="/test2/Z35-portallayout-comp.zul?popup1=true" />
							</panelchildren>
						</panel>
						<panel height="500px" title="Chart">
							<panelchildren>
								<include src="/test2/Z35-portallayout-comp.zul?chart1=true" />
							</panelchildren>
						</panel>
					</portalchildren>
					<portalchildren width="50%" fulfill="btn.onClick">
						<panel height="120px" title="Fisheye">
							<panelchildren>
								<include src="/test2/Z35-portallayout-comp.zul?fisheye1=true" />
							</panelchildren>
						</panel>
					</portalchildren>
			
				</portallayout>
			
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should not see any Javascript error");
});

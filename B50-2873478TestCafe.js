import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2873478TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2873478TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="" contentType="text/html;charset=UTF-8" zscript-language="javascript" ?>
			<window title="ZK5 RC Test - 01" border="normal" width="80%">
			<html><![CDATA[
			<ol>
				<li>If you can see this page and the under Grid, it is OK</li>
				<li>Done</li>
			</ol>
			]]></html>
			  <grid>
			      <columns sizable="true">
			        <column label="Fields" align="right" width="80px" />
			        <column label="" />
			      </columns>
			 
			      <rows>
			        <row>
			          <label value="NO1:" />
			          <textbox id="no1" constraint="no empty"/>
			        </row>
			        <row visible="false">
			          <label value="NO2:" />
			          <textbox id="no2" constraint="no empty"/>
			        </row>
			      </rows>
			  </grid>
			</window>`,
	);
	await t.expect(await ClientFunction(() => !!jq("div.z-grid")[0])()).ok();
});

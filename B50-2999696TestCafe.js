import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2999696TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2999696TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
	<li>If you see no Exception, then it is OK.</li>
</ol>
]]>
</html>
<grid hflex="min" vflex="min">
	<columns>
		<column hflex="min"/>
		<column hflex="min"/>
	</columns>
	<rows>
		<row>
			<label value="File:"/>
			<textbox width="98%"/>
		</row>
		<row>
			<label value="Type:"/>
			<hbox>
				<listbox rows="1" mold="select">
					<listitem label="Java Files,(*.java)"/>
					<listitem label="All Files,(*.*)"/>
				</listbox>
				<button label="Browse..."/>
			</hbox>
		</row>
		<row>
			<label value="Options:"/>
			<textbox rows="3" width="99%"/>
		</row>
	</rows>
</grid>
</zk>`,
	);
	let conditionStatementExpr_cafe0_0 = await ClientFunction(
		() => !!jq(".z-window-highlighted")[0],
	)();
	let conditionStatementExpr_cafe0_1 = await ClientFunction(
		() => !!jq(".z-window-modal")[0],
	)();
	if (conditionStatementExpr_cafe0_0 || conditionStatementExpr_cafe0_1) {
		await t.expect("false").ok();
	}
});

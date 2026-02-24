import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1881550TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1881550TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Error Stripe with Grid and Listbox in Modal Mode</n:p>
				<window title="Grid Demo" border="normal" width="360px" closable="true">
					<grid>
						<rows>
							<row>
								<label value="File:"/>
								<textbox width="99%"/>
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
					<button id="doModal" label="doModal" onClick="self.parent.doModal();"/>
				</window>	
			</zk>`,
	);
	let rowId_01_cafe = await ClientFunction(() =>
		jq(".z-rows tr.z-row:eq(1)").attr("id"),
	)();
	let rowId_02_cafe = await ClientFunction(() =>
		jq(".z-grid-odd").attr("id"),
	)();
	await t
		.expect(ztl.normalizeText(rowId_02_cafe))
		.eql(ztl.normalizeText(rowId_01_cafe));
	await t.click(Selector(() => zk.Desktop._dt.$f("doModal", true).$n()));
	await ztl.waitResponse(t);
	rowId_01_cafe = await ClientFunction(() =>
		jq(".z-rows tr.z-row:eq(1)").attr("id"),
	)();
	rowId_02_cafe = await ClientFunction(() => jq(".z-grid-odd").attr("id"))();
	await t
		.expect(ztl.normalizeText(rowId_02_cafe))
		.eql(ztl.normalizeText(rowId_01_cafe));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1911129TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1911129TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:p>Menuseparator\'s background should be shown.</n:p>
	<window title="Menu Demo" border="normal">
		<menubar id="menubar">
			<menu label="File" id="fm">
				<menupopup>
					<menuitem label="New" onClick="alert(self.label)"/>
					<menuitem label="Open" onClick="alert(self.label)"/>
					<menuitem label="Save" onClick="alert(self.label)"/>
					<menuseparator id="ms" />
					<menuitem label="Exit" onClick="alert(self.label)"/>
				</menupopup>
			</menu>
			<menu label="Help">
				<menupopup>
					<menuitem label="Index" onClick="alert(self.label)"/><menuseparator/>
					<menu label="About">
						<menupopup>
							<menuitem label="About ZK" onClick="alert(self.label)"/>
							<menuitem label="About Potix" onClick="alert(self.label)"/>
						</menupopup>
					</menu>
				</menupopup>
			</menu>
		</menubar>
	</window>
				
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$fm")[0]));
	await ztl.waitResponse(t);
	let ow_cafe = await ClientFunction(() => jq("$ms").width())();
	let oh_cafe = await ClientFunction(() => jq("$ms").height())();
	await t.expect(ow_cafe > 0).ok();
	await t.expect(oh_cafe > 0).ok();
});

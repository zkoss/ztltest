import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3036584TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3036584TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
<ol>
 <li>Move mouse over one of the menu below (don\'t click)</li>
 <li>If the popup remains (no closed), it is correct</li>
 <li>Then, click the menu item and the popup shall be closed</li>
</ol>
]]></html>
<window title="new page title" border="normal">
	<menubar>
		<menuitem label="Test" />
		<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
			<menupopup>
				<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png" label="New"
					onClick="alert(self.label)" />
				<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png" label="Open"
					onClick="alert(self.label)" />
				<menuitem image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png" label="Save"
					onClick="alert(self.label)" />
				<menuseparator />
				<menuitem label="Exit" image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png" onClick="alert(self.label)" />
			</menupopup>
		</menu>
	</menubar>
	<window title="Test" mode="popup" border="normal">
		Test...
	</window>
</window>
</zk>`,
	);
	await t.hover(Selector(() => jq(".z-menu > a")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq('@window[title="Test"]')).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq(".z-menuitem")[0]),
		{ offsetX: 6, offsetY: 6 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq('@window[title="Test"]')).is(":visible"),
			)(),
		)
		.notOk();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2080349TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2080349TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
	Clicks the following button, then a menu shall be popped up.
	<separator/>
	<button label="popup" popup="editPopup"/>
	<menupopup id="editPopup">
        <menuitem label="Undo"/>
        <menuitem label="Redo"/>
        <menu label="Sort">
			<menupopup>
		        <menuitem label="Sort by Name" autocheck="true"/>
		        <menuitem label="Sort by Date" autocheck="true"/>
			</menupopup>
        </menu>
	</menupopup>
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-menupopup")[0])()).ok();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2041674TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2041674TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk
	xmlns="http://www.zkoss.org/2005/zul"
	xmlns:h="http://www.w3.org/1999/xhtml">
	<window>
		<div>Hover mouse over disabled item, popup menu disappears(This is wrong.)</div>

		<menubar autodrop="true">
			<menu label="Popup Menu">
				<menupopup>
					<menuitem
						label="Hover mouse here..."
						href="http://www.zkoss.org"
						disabled="true" />
					<menuitem
						label="OK Here"
						href="http://www.zkoss.org" />
				</menupopup>
			</menu>
		</menubar>
	</window>
</zk>`,
	);
	await t.hover(Selector(() => zk.Widget.$(jq(".z-menu")).$n("a")));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-menuitem:eq(0)")[0]));
	await t
		.expect(await ClientFunction(() => jq(".z-menupopup").is(":visible"))())
		.ok();
});

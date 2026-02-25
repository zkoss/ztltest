import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2493245TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2493245TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="main">
        You shall see a modal window on top of this
        <zscript><![CDATA[
zoom = new HtmlMacroComponent();
zoom.setDynamicProperty("idColumn", 123);
zoom.setMacroURI("/test2/B30-2493245_macro.zul");
zoom.setParent(main);
zoom.afterCompose();
	]]></zscript>
      </window>`,
	);
	let winZindex_cafe = await ClientFunction(() =>
		jq(".z-modal-mask").css("z-index"),
	)();
	let popupZindex_cafe = await ClientFunction(() =>
		jq(".z-window-modal").css("z-index"),
	)();
	await t
		.expect(popupZindex_cafe >= winZindex_cafe)
		.ok(
			"The z-index of the main window should be more or equal than the z-index of the mask",
		);
});

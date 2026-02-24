import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2125788TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2125788TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
        <window id="win" title="My First Window" border="normal" width="200px" closable="true">
          Hello, World!
          <button label="2. Click Me" onClick=\'win.setTitle("If the window is in front of the mask, that is correct!")\'/>
        </window>
        <button label="1. Click ME First!" onClick="win.doHighlighted()"/>
      </window>`,
	);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let zIndexMask_cafe = await ClientFunction(() =>
		jq(".z-modal-mask").css("z-index"),
	)();
	let zIndexWindow_cafe = await ClientFunction(() =>
		jq("$win").css("z-index"),
	)();
	await t
		.expect(zIndexWindow_cafe >= zIndexMask_cafe)
		.ok(
			"The z-index of the window should be greater than or equal to the z-index of the mask",
		);
});

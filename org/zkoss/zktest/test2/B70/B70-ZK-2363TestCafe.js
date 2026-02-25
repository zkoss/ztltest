import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2363TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2363TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<zk>
	<div>
		Maximize the window and restore it, you should be able to resize the window without any error
	</div>
	<window title="Test Max" border="normal" position="center" sizable="true" maximizable="true" minimizable="true" closable="true" width="488px">
	  <menubar>
	    <menu label="File" >
	      <menupopup>
	        <menu label="Test"></menu>
	      </menupopup> 
	    </menu>
	  </menubar>
	</window>
</zk>`,
	);
	await t.click(
		Selector(() => jq(".z-window-maximize")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-window-maximized")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let width_cafe = await ClientFunction(() => jq("@window").width())();
	await t.drag(
		Selector(() => jq("@window")[0]),
		50,
		0,
		{ offsetX: 0, offsetY: 20 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("you shouldn't see any js error.");
});

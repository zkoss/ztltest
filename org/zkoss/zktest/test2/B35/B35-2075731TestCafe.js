import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075731TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075731TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<zk>
If you can\'t the loading progress bar to keep alive, the bug is fixed.
<panel title="table1" border="normal"  collapsible="true">
<panelchildren>
<tablelayout>
<tablechildren>
<panel>
<panelchildren>
<label value="Panel" />
</panelchildren>
</panel>
</tablechildren>
</tablelayout>
Panel
</panelchildren>
</panel>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-loading-icon")[0])())
		.notOk();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2916146TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2916146TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<textbox width="500px" value="Please press Backspace, the browser should do nothing." focus="true" readonly="true"/>
</zk>`,
	);
	await t.pressKey("end").pressKey("backspace");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@textbox")[0])()).ok();
	await t.pressKey("backspace");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@textbox")[0])()).ok();
});

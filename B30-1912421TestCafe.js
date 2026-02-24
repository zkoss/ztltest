import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1912421TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1912421TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>1.Click the button</n:p>
        <n:p>2.Overlapped window shall NOT disappears</n:p>
        <window id="win" title="I am here" border="normal" width="200px" mode="overlapped">
          never gone
          <button label="Please Click Me" onClick=\'win.invalidate()\'/>
        </window>
      </zk>`,
	);
	await t
		.expect(await ClientFunction(() => jq("$win").is(":visible"))())
		.ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$win").is(":visible"))())
		.ok();
});

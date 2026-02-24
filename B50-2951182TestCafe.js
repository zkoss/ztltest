import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2951182TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2951182TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    <window id="testWindow" width="200px">
If you can see the words, the bug is fixed.
          <button id="addBtn" label="Add" />
    </window>
    <zscript>
        testWindow.doHighlighted();
        testWindow.getFellow("addBtn").visible = false;

    </zscript>


</zk>`,
	);
	await t.wait(500);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(() => jq(jq("$testWindow")).is(":visible"))(),
		)
		.ok();
});

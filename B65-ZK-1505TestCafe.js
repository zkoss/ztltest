import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1505TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1505TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <label multiline="true">
                      Click "Access page" button, should see Progressing bar showed.
                    </label>
                    <div>
                      <button id="btn" label="Access page" onClick="Thread.sleep(10000L);"/>
                    </div>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0])).wait(1000);
	await t.expect(await ClientFunction(() => !!jq(".z-loading")[0])()).ok();
});

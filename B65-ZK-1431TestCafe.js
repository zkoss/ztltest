import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1431TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1431TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <label multiline="true">
                      Should not see "processing..." message.
                    </label>
                    <include height="200px" src="/test2/B65-ZK-1431-1.zul" mode="defer"/>
                  </zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-loading")[0])()).notOk();
});

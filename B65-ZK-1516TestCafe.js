import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1516TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1516TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        Should not see "processing..." bar.
        <hlayout>
          <textbox hflex="1" value="1"/>
          <textbox hflex="2" value="2"/>
          <timer/>
          <script/>
        </hlayout>
      </zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-loading")[0])()).notOk();
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2950801TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2950801TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					Check it will not happen js error
					<borderlayout>
						<east>
							<hbox hflex="1" vflex="1" style="padding-top:20px"/>
						</east>
						<center>
							<label value="center" />
						</center>
					</borderlayout>
				</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

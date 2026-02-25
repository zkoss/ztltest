import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2453TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2453TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
  <window border="normal" title="Progressmeter in 7.0.3 with \'visible=false\' give JS error, page rendering is stopped" >
    <label multiline="true">
    	1. you should load this page without js error.
    </label>
    <progressmeter id="progressMeter" visible="false" />

  </window>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 0).ok();
});

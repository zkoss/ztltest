import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2065TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2065TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Macro Demo" ?>
<?component name="test-ma"   macroURI="test2/B70-ZK-2065-1.zul" ?>
<window border="normal" width="400px">
	<label multiline="true">
		1. The below should show 11111111 in the same line.
		2. The page should not be cached.
	</label>
		3. Paste the HTML code to <a href="http://validator.w3.org/">validator</a> should not show any error.
	<separator/>
	<test-ma/>
	<test-ma/>
</window>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@macro .z-label:contains(1111)").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2)
		.ok("The below should show 11111111 in the same line.");
});

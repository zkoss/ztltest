import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2181TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2181TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>the radio should be checked</div>
	<radiogroup id="rg" hflex="1">
		<radio checked="true" label="radio" />
	</radiogroup>
	<span hflex="1">
		<radio checked="true" label="radio" />
	</span>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("input[checked=checked]").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2)
		.ok("the radio should be checked");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1728TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1728TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	when you key up or down in combobox, you should not see \'test1\' or \'test2\'
	<combobox>
		<comboitem label="test1" visible="false" />
		<comboitem label="test2" visible="false" />
	</combobox>
</zk>`,
	);
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	let bothVisible_cafe = await ClientFunction(() =>
		jq(".z-comboitem:contains(test1)").is(":visible"),
	)();
	await t
		.expect(bothVisible_cafe)
		.notOk("you should not see 'test1' or 'test2'");
});

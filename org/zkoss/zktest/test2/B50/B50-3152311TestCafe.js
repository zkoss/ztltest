import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3152311TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3152311TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
		 <li>If you see the datebox, the bug has been fixed.</li>
		</ol>
	]]></html>
	<datebox constraint="between 20071225 and 20071203"/>
</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@datebox")[0])()).ok();
	await t
		.expect(await ClientFunction(() => jq(jq("@datebox")).is(":visible"))())
		.ok();
});

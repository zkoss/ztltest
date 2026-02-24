import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3162238TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3162238TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
					<ol>
						<li>Click on Show Null, the included content should disappear, 
						otherwise it is a bug.</li>
					</ol>
				]]></html>
				<include id="inc" src="/test2/B50-3162238-inc.zul" />
				<button id="btn" label="Show Null" onClick=\'inc.src = null\' />
			</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-embedded")[0])())
		.ok("embedded window should exist before button clicked");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-embedded")[0])())
		.notOk("embedded window should not exist after button clicked");
});

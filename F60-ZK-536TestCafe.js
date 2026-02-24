import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-536TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-536TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ol>
			<li>Each groupbox below should have title.</li>
			</ol>
			]]></html>
				<hbox>
					<groupbox id="gbxOne" width="200px" height="200px" title="groupbox one" open="false" />
					<groupbox id="gbxTwo" width="200px" mold="3d" height="200px" title="groupbox two" open="false" />
				</hbox>
			</zk>`,
	);
});

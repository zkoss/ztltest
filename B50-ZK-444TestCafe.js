import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-444TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-444TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<toolbar>
					<toolbarbutton id="btn" label="click me" onClick=\'alert(componentScope.get("key"))\' >
						<custom-attributes key="SomeValue" />
					</toolbarbutton>
				</toolbar>
				<div>
					Click on the Toolbarbutton. There should be a Messagebox and no javascript error.
				</div>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});

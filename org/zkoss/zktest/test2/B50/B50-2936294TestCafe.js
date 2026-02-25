import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2936294TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2936294TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<listbox id="listbox">
						<listitem label="listitem 1"/>
						<listitem label="listitem 2" selected="true"/>
					</listbox>
					<button id="btn" label="Click Me to clear the selection" onClick=\'listbox.setSelectedItem(null)\'/>
				</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listitem-selected")[0])())
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listitem-selected")[0])())
		.notOk();
});

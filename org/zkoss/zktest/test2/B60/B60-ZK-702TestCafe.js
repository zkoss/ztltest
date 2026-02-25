import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-702TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-702TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Click on button of combobutton, you should see a message box.</div>
				<combobutton id="cb" label="popup" onClick=\'alert(self.label)\'>
				</combobutton>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-highlighted:contains(popup)")[0],
			)(),
		)
		.ok("Should show a message box");
});

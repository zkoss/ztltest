import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1879511TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1879511TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>
					Please type some words into combobox, and then click its popup
					button, and then click the blank of the drop-down list and click
					the outside of the combobox. You should see the error message.
				</n:p>
				<combobox id="cb1" constraint="strict" />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb1", true).$n("real")));
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("cb1", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Desktop._dt.$f("cb1", true).$n("real")),
		);
	await ztl.waitResponse(t);
	await t
		.pressKey("z k")
		.click(Selector(() => jq(zk.Desktop._dt.$f("cb1", true).$n("btn"))[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb1", true).$n("pp")));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});

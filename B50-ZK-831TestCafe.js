import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-831TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-831TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <window title="Spinner" border="normal">
                      1. Please type the number to the input element - "12345678910"
                      <separator/>
                      2. You should see an error message like "Out of range..."
                      <spinner id="spinner"/>
                      <button label="show" onClick=\'alert("" + spinner.getValue())\'/>
                    </window>
                  </zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-spinner")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 4 5 6 7 8 9 1 0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("should see an error message");
});

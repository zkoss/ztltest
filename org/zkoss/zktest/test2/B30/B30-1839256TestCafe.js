import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1839256TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1839256TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<window title="Test of long operation">
						Clicks the Test button and you shall see alert after 10 seconds (Bug 1839256).
						To verify bug 1907640, test this file with Glassfish.
						<separator/>
						Moreover, all following clicks are ignored before alert is shown (Feature 1859533).
						<separator/>
						<button label="Test" autodisable="self">
							<attribute name="onClick">
							org.zkoss.lang.Threads.sleep(10000);
							alert("Everything goes fine");
							</attribute>
						</button>
					</window>
				</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let conditionStatementExpr_cafe0_0 = await ClientFunction(
		() => !!jq(".z-window-highlighted")[0],
	)();
	let conditionStatementExpr_cafe0_1 = await ClientFunction(
		() => !!jq(".z-window-modal")[0],
	)();
	if (conditionStatementExpr_cafe0_0 || conditionStatementExpr_cafe0_1) {
		await t.expect("true").ok();
	}
	{
		await t.expect("false").ok();
	}
});

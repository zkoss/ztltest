import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2922847TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2922847TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Please cleck the toolbarbutton label to see the font should be bold
				<toolbarbutton id="tbtn" label="click me" style="font-weight:bold" 
						onClick=\'self.style = self.style.equals("font-weight:bold;") ? "font-weight:bold;":"font-weight:normal;"\'/>
				</zk>`,
	);
	await t
		.expect(ztl.normalizeText("700bold"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-toolbarbutton-content").css("font-weight"),
				)(),
			),
			"",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("tbtn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("400normal"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-toolbarbutton-content").css("font-weight"),
				)(),
			),
			"",
		);
});

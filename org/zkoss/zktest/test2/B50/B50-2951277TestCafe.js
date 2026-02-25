import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2951277TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2951277TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
You should see the value <label id="l" style="font-weight:bold"/> in the textbox.
<separator/>
<textbox id="test" cols="35"/>
<zscript>
test.setText("Just a \\"test\\" with quotes");
l.setValue("Just a \\"test\\" with quotes");
</zscript>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("test", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText('Just a "test" with quotes'));
});

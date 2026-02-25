import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2911379TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2911379TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			You should see each label is the same as that of input element.
			<vbox>
			<hbox>
			<doublebox id="percent" format="0.00%;(0.00%)" width="200px"/> = 99.00%
			</hbox>
			<hbox>
			<doublebox id="value" format="#,##0.##;(#,##0.##)" width="200px"/> = (200,000) 
			</hbox>
			<hbox>
			<doublebox id="value2" format="#,##0.00;($#,##0.00)" width="200px"/> = ($200,000.00) 
			</hbox>
			<hbox>
			<decimalbox id="decimal" format="##0.00;(#,##0.00)" width="200px"/> = (1,234,567,890.00)
			</hbox>
			</vbox>
			
			<zscript>
			decimal.value = new java.math.BigDecimal(-1234567890.0);
			</zscript>
			<zscript>
			percent.value = 0.99;
			value.value = -200000;
			percent2.value = 0.99;
			value2.value = -200000;
			</zscript>
			
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("percent", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("99.00%"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("value", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("(200,000)"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("value2", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("($200,000.00)"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("decimal", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("(1,234,567,890.00)"));
});

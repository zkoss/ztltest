import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2989808TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2989808TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<decimalbox id="d1" format="#####.0##%" value="123.456"/>
			<decimalbox id="d2" format="##0.##%" value="123"/>
			<decimalbox id="d3" width="150px" format="R ##,###,###,###.00%" value="123456"/>
			<decimalbox id="d4" width="150px" format="#,###,###.00%" value="123456"/>			
		</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d1", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12345.6%"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d2", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12300%"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d3", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("R 12,345,600.00%"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d4", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12,345,600.00%"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("d1", true).focus();
	})();
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d1", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12345.6%"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("d2", true).focus();
	})();
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d2", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12300%"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("d3", true).focus();
	})();
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d3", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("R 12,345,600.00%"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("d4", true).focus();
	})();
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d4", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12,345,600.00%"));
});

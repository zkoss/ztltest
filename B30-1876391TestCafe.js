import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1876391TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1876391TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				Click the test button and you shall see "OK" being appended.
				<button id="ok" label="test">
					<attribute name="onClick"><![CDATA[
				cb.setText("BB");
				Comboitem ci = cb.getSelectedItem();
				new Label(ci != null && "BB".equals(ci.label) ? "OK": "Failed "+ci)
					.setParent(self.parent);
					]]></attribute>
				</button>
				<combobox id="cb">
					<comboitem label="AA"/>
					<comboitem label="BB"/>
					<comboitem label="CC"/>
				</combobox>
			</window>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")))
		.click(Selector(() => zk.Desktop._dt.$f("ok", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("BB"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("OK"));
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1882802TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1882802TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
      click enable/disable and make sure every one is disable/enabled
      <vbox>
	<button label="enable/disable"
		onClick="a1.disabled= !a1.disabled;a2.disabled= !a2.disabled;a3.disabled= !a3.disabled;a4.disabled= !a4.disabled;a5.disabled= !a5.disabled;a6.disabled= !a6.disabled;a7.disabled= !a7.disabled;" />
	<textbox id="a1" rows="5" cols="40">
		<attribute name="value">text line1... text line2...</attribute>
	</textbox>
	<datebox id="a2" />
	<combobox id="a3">
		<comboitem label="item1" value="item1value" />
		<comboitem label="item1" value="item1value" />
	</combobox>
	<textbox id="a4" />
	<intbox id="a5" />
	<radiogroup>
		<radio id="a6" label="Apple" />
	</radiogroup>
	<checkbox id="a7" label="Apple" />
      </vbox>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(":disabled").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(":disabled").length)(),
			),
		)
		.eql(ztl.normalizeText("7"));
});

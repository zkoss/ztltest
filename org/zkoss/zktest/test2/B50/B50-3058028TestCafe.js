import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3058028TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3058028TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
	<ul>
	<li>Test environment: IE</li>
	<li>Press TAB to change focus to "bb"</li>
	<li>Press TAB again and the focus shall switch to "cc"</li>
	</ul>
	]]></html>
	
	<textbox focus="true"/>
	<combobox value="bb">
		<comboitem label="aa"/>
		<comboitem label="bb"/>
	</combobox>
	<combobox value="cc">
		<comboitem label="aa"/>
		<comboitem label="bb"/>
	</combobox>
</zk>`,
	);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox:eq(0)")).$n("real")).css(
						"box-shadow",
					),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox:eq(1)")).$n("real")).css(
						"box-shadow",
					),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2938061TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2938061TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				    Please select a comboitem, then the background of the combobox should be changed.
				    <combobox id="c" onSelect="setColor()" style="background: violet;">
				        <comboitem label="Comboitem 1" />
				        <comboitem label="Comboitem 2" />
				        <comboitem label="Comboitem 3" />
				    </combobox>
				    <zscript>
				        <![CDATA[
				            void setColor() {
								if (c.getSelectedIndex() == 1) c.setStyle("background: blue;");
								else if (c.getSelectedIndex() == 2) c.setStyle("background: red;");
								else c.setStyle("background: green;");
							}
				        ]]>
				    </zscript>
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("c", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("green"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("c", true)).css("backgroundColor"),
					)(),
				),
			),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("c", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("blue"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("c", true)).css("backgroundColor"),
					)(),
				),
			),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("c", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("red"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("c", true)).css("backgroundColor"),
					)(),
				),
			),
		)
		.ok();
});

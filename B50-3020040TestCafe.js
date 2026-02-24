import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3020040TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3020040TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ul>
			<li>Click "Unselect first", and then "item 2" and "item 3" shall remain selected</li>
			</ul>
			]]></html>
			
			<listbox id="box" multiple="true" checkmark="true">
			<listhead>
			<listheader label="Index"/>
			</listhead>
			<listitem label="item 1" selected="true"/>
			<listitem label="item 2" selected="true"/>
			<listitem label="item 3" selected="true"/>
			</listbox>
			<button id="btn" label="Unselect first" onClick="box.removeItemFromSelection(box.getItemAtIndex(0))"/>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("box", true).$n("rows")).find(
							".z-listitem",
						)[1].className,
				)(),
			),
		)
		.contains(ztl.normalizeText("z-listitem-selected"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("box", true).$n("rows")).find(
							".z-listitem",
						)[2].className,
				)(),
			),
		)
		.contains(ztl.normalizeText("z-listitem-selected"), "");
});

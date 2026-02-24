import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2027442TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2027442TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="wnd" width="100%" title="Model and Paging">
<html><![CDATA[
<p>1. Yous shall see a button "Load".<br/>
2. Click "Load" button.<br/>
3. You shall see a list with "0", "1", "2", "3"  and so on in order.<br/>
4. If not in order, it is a bug.<br/>
5. Done.
</p>
]]></html>
	<zscript><![CDATA[
		void load() { 
			int num = 16;
		    String[] entries = new String[num];
		    for(int j=0; j < num; ++j) {
		    	entries[j] = ""+j;
		    }
			lbx.setModel(new SimpleListModel(entries));
		} 
	]]></zscript>

	<button id="load" label="Load" onClick="load()" />
	<listbox id="lbx" mold="paging" pageSize="5">
	</listbox>
</window>`,
	);
	await t.click(Selector(() => jq('@button[label="Load"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
});

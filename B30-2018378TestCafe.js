import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2018378TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2018378TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
1. You should see listbox with item0 ~ item19.<br/>
2. Press buton "remove previous item" and you should see the 1st item is removed
from the listbox (item0).<br/>
3. Press the button again, you should see item1 is removed.<br/>
4. Done.<br/>
]]></html>
<window>
<zscript><![CDATA[
List lst = new ArrayList(20);
ListModel model = new ListModelList(lst, true);
for(int j = 0; j < 20; ++j) {
lst.add("item"+ j);
}
]]></zscript>
<listbox model="\${model}" rows="10"/>
<button label="remove previous item" onClick=\'Iterator it = model.listIterator(1);
it.previous(); it.remove();\'/>
</window>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:first").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item0"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:first").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item1"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:first").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item2"));
});

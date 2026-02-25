import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2017848TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2017848TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<zk>
	<html><![CDATA[
		<ol>
			<li>You should see listbox with item0 to item19.</li>
			<li>Press Button "remove 1st item" and you should see the 1st item (item0) is removed from the listbox.</li>
			<li>Press the button again, you should see item1 is removed.</li>
		</ol>
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
	<button label="remove 1st item" 
		onClick=\'Iterator it = model.iterator(); it.next(); it.remove()\'/>
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

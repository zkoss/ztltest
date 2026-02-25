import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3005632TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3005632TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
<html>
<![CDATA[
<ol>
<li>You shall see listbox with item0~item9</li>
<li>Press "Replace with empty model" button, you shall see the listbox contents are clear to empty(white background).</li>
<li>If not, it is a bug.</li>
</ol>
]]>
</html>
<zscript><![CDATA[
List lst = new ArrayList(120);
ListModel model = new ListModelList(lst, true);
for(int j = 0; j < 120; ++j) {
lst.add("item"+ j);
}
]]></zscript>
<listbox id="lb" model="\${model}" rows="10"/>
<button id="btn" label="Replace with empty model" onClick=\'lb.setModel(new ListModelList(new ArrayList()))\'/>
</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@listitem")[0])()).notOk();
});

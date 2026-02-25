import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3219005TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3219005TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please click the "delete item5" and the last one should be "item 11" not "item 12".(ZK CE and PE version only)
<zscript>
<![CDATA[
import java.util.*;

List datas = new ArrayList();
for(int i=1;i<=15;i++){
datas.add("item "+i);
}
ListModel model = new ListModelList(datas,true);
]]>
</zscript>
<grid model="\${model}" mold="paging" pageSize="10"/>
<button label="delete item5">
<attribute name="onClick">
<![CDATA[
Collection m = (Collection)model;
m.remove(model.getElementAt(5));
]]>
</attribute>
</button>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:last").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("11"), "");
});

import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2821745TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2821745TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
		    <zscript>
		        String[] data = new String[10];
				for(int j=0; j &lt; data.length; ++j) {
					data[j] = "option "+j;
				}
				ListModel strset = new SimpleListModel(data);
			
		    </zscript>
		    <listbox id="list" width="200px" rows="10" onSelect=\'gb.open = true;\' model="&#36;{strset}"></listbox>
		    <groupbox id="gb" mold="3d" width="400px">
		        <caption label="Quickly press on the Close Me button, and then select one item, the groupbox should open again!"/>
		        <button label="Close Me" onClick="gb.open = false"/>
		    </groupbox>
		</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listcell:contains(option 5)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@groupbox").find(".z-groupbox-content").css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("block"));
});

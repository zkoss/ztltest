import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2787077TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2787077TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<zscript><![CDATA[ 
			
					ArrayList data = new ArrayList();
					for (int i = 1; i <= 42; i++) {
						data.add("Data " + i);
					}
			
					ListModel dataModel = new SimpleListModel(data);
					 ]]></zscript>
			<listbox id="listbox" mold="paging"
			pageSize="10" pagingPosition="top" model="\${dataModel}" activePage="4">
			<listhead>
			<listheader value="Data"/>
			</listhead>
			</listbox>
			
			<button id="button" label="Click Me, you should not see any error!">
			<attribute name="onClick"><![CDATA[ 
			
					ArrayList data = new ArrayList();
					for (int i = 1; i <= 39; i++) {
						data.add("Data " + i);
					}
			
					ListModel dataModel = new SimpleListModel(data);
					listbox.setModel(dataModel);
					 ]]></attribute>
			</button>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("button", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("div.z-window-modal")[0])())
		.notOk();
});

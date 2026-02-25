import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2782751TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2782751TestCafe", async (t) => {
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
				
				<button id="button" label="Click Me, you should see the item stay at Data 41">
				<attribute name="onClick"><![CDATA[ 
				
						ArrayList data = new ArrayList();
						for (int i = 1; i <= 41; i++) {
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
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listcell").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listcell").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Data 41"));
});

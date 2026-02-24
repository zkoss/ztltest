import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1601TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1601TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click "clear" button, should not see paging navigation bar on Listbox/Grid.
	<zscript><![CDATA[
		org.zkoss.zul.ListModel dataModel = new org.zkoss.zktest.test2.grid.FakeListModel(45);
	]]></zscript>
	<listbox id="listbox" mold="paging" model="\${dataModel}" pageSize="10" activePage="4">
		<listhead>
			<listheader label="Listbox Data" />
		</listhead>
	</listbox>
	<grid id="grid" mold="paging" model="\${dataModel}" pageSize="10" activePage="4">
		<columns>
			<column label="Grid Data" />
		</columns>
	</grid>
	<button label="Clear">
		<attribute name="onClick">
			listbox.setModel(new SimpleListModel(new ArrayList()));
			grid.setModel(new SimpleListModel(new ArrayList()));
		</attribute>
	</button>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Clear)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox .z-paging").css("display"),
				)(),
			),
			"should not see paging navigation bar on Listbox/Grid.",
		);
	await t
		.expect(ztl.normalizeText("none"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-grid .z-paging").css("display"),
				)(),
			),
			"should not see paging navigation bar on Listbox/Grid.",
		);
});

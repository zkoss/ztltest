import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F65-ZK-2014TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F65-ZK-2014TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Click checkbox on Listheader.
	2. Should see button label changed accordingly.
	</label>
	<zscript><![CDATA[
	import org.zkoss.zktest.test2.grid.FakeListModel;
	FakeListModel model = new FakeListModel(200);
	model.setMultiple(true);
	]]></zscript>
	<listbox checkmark="true" multiple="true" width="350px" model="\${model}" mold="paging" pageSize="5">
		<custom-attributes org.zkoss.zul.listbox.rod="false"/>
		<attribute name="onCheckSelectAll"><![CDATA[
			if (event.isChecked()) {
				btn.setLabel("Select All Checked");
			} else {
				btn.setLabel("Select All Un-Checked");
			}
		]]></attribute>
		<listhead>
			<listheader id="hd" label="col" />
		</listhead>
	</listbox>
	<button id="btn" label="button" />
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-listheader")).$n("cm")));
	await ztl.waitResponse(t);
	await t.expect("false").ok("Should see button label changed accordingly.");
});

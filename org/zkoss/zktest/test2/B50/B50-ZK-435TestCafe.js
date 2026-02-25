import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-435TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-435TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>For both Listbox and Grid, the onAfterRender should be fired only once. (Only see one label on the top of each Listbox/Grid.)</div>
				<zscript><![CDATA[
					String[] ar = new String[20];
					for (int i = 0; i < ar.length; i++)
						ar[i] = "item " + (i + 1);
					ListModelList list = new ListModelList(Arrays.asList(ar));
					class MyListitemRenderer implements ListitemRenderer {
						public void render(Listitem item, Object data, int index) throws Exception {
							item.setValue(data);
							item.setLabel(data.toString());
						}
					}
					class MyRowRenderer implements RowRenderer {
						public void render(Row row, Object data, int index) throws Exception {
							row.setValue(data);
							row.appendChild(new Label(data.toString()));
						}
					}
					MyListitemRenderer iren = new MyListitemRenderer();
					MyRowRenderer rren = new MyRowRenderer(); 
				]]></zscript>
				Listbox: <div id="div" />
				<listbox model="\${list}" mold="paging" pageSize="5" itemRenderer="\${iren}" 
					onAfterRender=\'div.appendChild(new Label("onAfterRender "));\' />
				Grid: <div id="div2" />
				<grid model="\${list}" mold="paging" pageSize="5" rowRenderer="\${rren}" 
					onAfterRender=\'div2.appendChild(new Label("onAfterRender "));\' />
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("div", true).$n().childNodes.length,
		)(),
	);
	await t.expect(verifyVariable_cafe_0_0 == 1).ok();
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("div2", true).$n().childNodes.length,
		)(),
	);
	await t.expect(verifyVariable_cafe_1_1 == 1).ok();
});

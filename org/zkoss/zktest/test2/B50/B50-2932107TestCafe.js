import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2932107TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2932107TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					Please select a drop down list, and than you should see the selected item still exists.
					<listbox id="listbox" mold="paging" width="500px">
						<auxhead>
							<auxheader colspan="1">
								<combobox id="insideHeaderCombobox" onSelect="loadItemsFromInside()">
									<comboitem label="Add 1 item" />
									<comboitem label="Add 2 items" />
									<comboitem label="Add 3 items" />
								</combobox>
							</auxheader>
						</auxhead>
					<listhead>
					<listheader label="Listheader"/>
					</listhead>
					</listbox>

					<zscript>
					<![CDATA[
					void loadItemsFromOutside() {
					for (int i = 0; i < outsideHeaderCombobox.getSelectedIndex()+1; i ++)
					listbox.appendChild(new Listitem("Element"));
					}

					void loadItemsFromInside() {
					for (int i = 0; i < insideHeaderCombobox.getSelectedIndex()+1; i ++)
					listbox.appendChild(new Listitem("Element"));
					}
					]]>
					</zscript>
				</zk>`,
	);
	await t.click(
		Selector(() =>
			zk.Desktop._dt.$f("insideHeaderCombobox", true).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Desktop._dt.$f("insideHeaderCombobox", true).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-comboitem-selected:contains(1)")[0],
			)(),
		)
		.ok();
});

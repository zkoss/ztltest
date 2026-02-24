import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1857731TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1857731TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Listbox Bug">
        <toolbarbutton id="With Bug" label="Click Me! And no error msg!" onClick="openNewTab()"/>
        <tabbox>
          <tabs id="tbsMain">
            <tab label="tab1"/>
          </tabs>
          <tabpanels id="tbpMain">
            <tabpanel>
              <listbox width="250px">
                <listhead sizable="true">
                  <listheader label="name"/>
                  <listheader label="gender"/>
                </listhead>
                <listitem>
                  <listcell label="Mary"/>
                  <listcell label="FEMALE"/>
                </listitem>
                <listitem>
                  <listcell label="John"/>
                  <listcell label="MALE"/>
                </listitem>
                <listitem>
                  <listcell label="Jane"/>
                  <listcell label="FEMALE"/>
                </listitem>
                <listitem>
                  <listcell label="Henry"/>
                  <listcell label="MALE"/>
                </listitem>
              </listbox>
            </tabpanel>
          </tabpanels>
        </tabbox>
        <zscript><![CDATA[
	public void openNewTab()
	{
		Tabpanel tabPanel = new Tabpanel();
		tbpMain.appendChild(tabPanel);
		
		Tab tab = new Tab();
		tab.setLabel("Tab2");
		tbsMain.appendChild(tab);
		
		tabPanel.appendChild(new Label("Test"));
		
		tab.setSelected(true);
	}
	]]></zscript>
      </window>`,
	);
	await t.click(Selector(() => jq(".z-toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(
				() => jq(".z-label:contains(Test)")[0] != null,
			)(),
		)
		.ok();
});

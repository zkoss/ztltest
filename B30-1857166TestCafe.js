import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1857166TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1857166TestCafe", async (t) => {
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
                Listbox lb = new Listbox();
                new Listitem("test").setParent(lb);
                tabPanel.appendChild(lb);
        
                tab.setSelected(true);
            }
            ]]></zscript>
        </window>`,
	);
	await t.click(Selector(() => jq("@toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-msgbox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq("@tab:eq(1)")[0])()).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@tabpanel:eq(1) @listbox").is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-msgbox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq("@tab:eq(2)")[0])()).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@tabpanel:eq(2) @listbox").is(":visible"),
			)(),
		)
		.ok();
});

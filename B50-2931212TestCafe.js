import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2931212TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2931212TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<tabbox  id="tabs">
    <tabs>
        <tab label="Close Me, you should see aa, rather than bb" closable="true" id="aa" onClose=\'alert(tabs.getSelectedTab().getId())\'/>
        <tab label="Tab 2" closable="true" id="bb"/>
        <tab label="Tab 3" closable="true"/>
        <tab label="Tab 4" closable="true"/>
        <tab label="Tab 5" closable="true"/>
    </tabs>
    <tabpanels>
        <tabpanel>
            This is panel 1
        </tabpanel>
        <tabpanel>
            This is panel 2
		The second panel
        </tabpanel>
        <tabpanel>
            This is panel 3
        </tabpanel>
        <tabpanel>
            This is panel 4
        </tabpanel>
        <tabpanel>
            This is panel 5
        </tabpanel>
    </tabpanels>
</tabbox>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("aa", true).$n("cls")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label").html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("aa"));
});

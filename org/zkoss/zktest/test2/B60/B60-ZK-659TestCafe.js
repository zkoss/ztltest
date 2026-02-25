import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-659TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-659TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <zscript><![CDATA[ 
import org.zkoss.zul.*;
	class Ctrl extends org.zkoss.zk.ui.util.GenericForwardComposer {
		Div main;
		Div cave;
		Tabbox tabbox;
		Tabs tabs;
		Button btn;
		
		public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
		}
		
		public void onClick$btn() {
			tabs.getChildren().clear();
			for (int i = 1; i <= 3; i++) {
				Tab a = new Tab("Tab " + i);
				a.setParent(tabs);
			}
		}
		
		public void onSelect$tabbox(Event evt) {
			inf.appendChild(new Label("selectd " + tabbox.getSelectedTab().getLabel()));
		}
	}
]]></zscript>
                    <html><![CDATA[
    <h4>Test steps</h4>
    <ul>
    	<li>Click "Create tab button"</li>
    	<li>Click "Tab 2" will display a message, "selectd Tab 2", at the end</li>
    	<li style="color:red;">Click "Tab 1" shall display another message, "selectd Tab 1", at the end (if not, it fails)</li>
    </ul>
]]></html>
                    <div id="main" apply="Ctrl">
                      <button id="btn" label="Create tab"/>
                      <div id="cave">
                        <tabbox id="tabbox">
                          <tabs id="tabs">
                          </tabs>
                        </tabbox>
                      </div>
                    </div>
                    <vlayout id="inf"/>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tab:contains(Tab 2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-vlayout-inner:contains(selectd Tab 2)")[0],
			)(),
		)
		.ok("will display a message, 'selectd Tab 2' at the end");
	await t.click(Selector(() => jq(".z-tab:contains(Tab 1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-vlayout-inner:contains(selectd Tab 1)")[0],
			)(),
		)
		.ok("shall display another message, 'selectd Tab 1', at the end");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-vlayout-inner:contains(selectd Tab 1)").html(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-vlayout-inner:contains(selectd Tab 2)")
						.next()
						.html(),
				)(),
			),
			"shall display another message, 'selectd Tab 1', at the end",
		);
});

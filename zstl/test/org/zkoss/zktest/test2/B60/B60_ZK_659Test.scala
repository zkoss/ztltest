package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-659.zul")
class B60_ZK_659Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
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
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()

        click(jq(".z-tab:contains(Tab 2)"))
        waitResponse()
        val tab2label = jq(".z-vlayout-inner:contains(selectd Tab 2)")
        verifyTrue("will display a message, 'selectd Tab 2' at the end", tab2label.exists())

        click(jq(".z-tab:contains(Tab 1)"))
        waitResponse()

        val tab1label = jq(".z-vlayout-inner:contains(selectd Tab 1)")
        verifyTrue("shall display another message, 'selectd Tab 1', at the end", tab1label.exists())

        verifyEquals("shall display another message, 'selectd Tab 1', at the end", tab2label.next().html(), tab1label.html())

      })

  }
}

package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1821.zul")
class B65_ZK_1821Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native" xmlns:w="client">
	<label multiline="true">
	1. Click "Select Tab2" button.
	2. Mouse over on red part, should not see JS Error showed.
	</label>
	<button id="tab2btn" label="Select Tab2">
		<attribute name="onClick">
			tabbox.setSelectedTab(tab2);
			tabbox.invalidate();
		</attribute>
	</button>
	<tabbox id="tabbox">
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1"></tab>
			<tab id="tab2" label="Tab 2"></tab>
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>Test</tabpanel>
			<tabpanel>
				<n:div>
					<div style="background:red;padding: 10px;">
						<attribute w:name="doMouseOver_"><![CDATA[
							function (evt) {
								if (!this.desktop) {
									zk.error('bind failed');
								}
							}
						]]></attribute>
						<window title="window inside native" vflex="true" hflex="false">
						</window>
					</div>
				</n:div>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Tab)"))
        waitResponse()
        mouseOver(jq(".z-window-embedded").toWidget().$n("cap"))
        waitResponse()
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}
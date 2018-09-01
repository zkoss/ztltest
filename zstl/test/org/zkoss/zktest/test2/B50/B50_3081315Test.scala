/* B50_3081315Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3081315Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html>
		<![CDATA[
			<ol>
			<li>Click close button in tab1, a confirm dialog will appear.</li>
			<li>Click no</li>
			<li>the tab1 shall be selected</li>
			</ol>
		]]>
	</html>
	<zscript><![CDATA[
		public void doClose(Event event) {
			Tab tab = (Tab) event.getTarget();
			Messagebox.show("Delete?", "Prompt", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener() {
						public void onEvent(Event evt) {
							if (Messagebox.YES == ((Integer) evt.getData())
									) {
								tab.close();
							}
						}
					});
			event.stopPropagation();
		}
	]]></zscript>
	<tabbox>
		<tabs>
			<tab label="tab1" closable="true" onClose="doClose(event);" />
			<tab label="tab2" closable="true" onClose="doClose(event);" />
			<tab label="tab3" closable="true" onClose="doClose(event);" />
		</tabs>
		<tabpanels>
			<tabpanel>Tab1</tabpanel>
			<tabpanel>Tab2</tabpanel>
			<tabpanel>Tab3</tabpanel>
		</tabpanels>
	</tabbox>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals(3, jq(".z-tab").length())
      click(jq(".z-tab:eq(1)").toWidget().$n("cls"))
      waitResponse()
      click(jq(".z-button:eq(0)"))
      waitResponse()
      verifyEquals(2, jq(".z-tab").length())
      click(jq(".z-tab:eq(0)").toWidget().$n("cls"))
      waitResponse()
      click(jq(".z-button:eq(1)"))
      waitResponse()
      verifyEquals(2, jq(".z-tab").length())
    })
  }
}




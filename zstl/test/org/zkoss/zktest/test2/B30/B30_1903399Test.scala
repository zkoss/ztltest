/* B30_1903399Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1903399Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window title="Context Menu and Right Click" border="normal" width="450px">
				<label id="desp" value="Right click at all following labels. It shall bring the context menu." />
				<separator bar="true"/>
				<label id="lb1" value="Direct assign" context="editPopup"/>
				<separator bar="true"/>
				<label id="test" value="setContext(editPopup)" />
				<separator bar="true"/>
				<label id="test2" value="setContext(editPopup.getID())" />
				
				<menupopup id="editPopup">
					<menuitem label="Undo"/>
					<menuitem label="Redo"/>
					<menu label="Sort">
						<menupopup>
							<menuitem label="Sort by Name" autocheck="true"/>
							<menuitem label="Sort by Date" autocheck="true"/>
						</menupopup>
					</menu>
				</menupopup>
				
				<zscript>
					test.setContext( editPopup );
					test2.setContext( editPopup.getId() );
				</zscript>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val desp = ztl$engine.$f("desp")
    val lb1 = ztl$engine.$f("lb1")
    val test = ztl$engine.$f("test")
    val test2 = ztl$engine.$f("test2")
    val editPopup = ztl$engine.$f("editPopup")
    runZTL(zscript, () => {
      var $cap = jq(jq("@window").toWidget().$n("cap"))
      verifyEquals(0, jq("@menupopup:visible").length())
      contextMenu(jq("$lb1"))
      waitResponse()
      verifyTrue(jq("@menupopup:visible").exists())
      clickAt($cap, "10,10")
      waitResponse()
      verifyEquals(0, jq("@menupopup:visible").length())
      contextMenu(jq("$test"))
      waitResponse()
      verifyTrue(jq("@menupopup:visible").exists())
      clickAt($cap, "10,10")
      waitResponse()
      verifyEquals(0, jq("@menupopup:visible").length())
      contextMenu(jq("$test2"))
      waitResponse()
      verifyTrue(jq("@menupopup:visible").exists())
      clickAt($cap, "10,10")
      waitResponse()
      verifyEquals(0, jq("@menupopup:visible").length())
    })
  }
}




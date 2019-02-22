/* F86_ZK_3963.java

        Purpose:

        Description:

        History:
                Mon Aug 06 16:18:35 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class F86_ZK_3963_1Test extends ZTL4ScalaTestCase {
  //copy from F86_ZK_3963Test - Start
  val getSelectedItem = findButtonByContent("getSelectedItem()")
  val getVisibleItemCount = findButtonByContent("getVisibleItemCount()")
  val isOpen = findButtonByContent("isOpen")
  val isSelected = findButtonByContent("isSelected")

  def findButtonByContent(content: String): JQuery = {
    return jq(".z-button:contains(" + content + ")")
  }

  def findNodeByContent(content: String): JQuery = {
    return jq(".z-organigram:eq(0) .z-orgnode:contains(" + content + ")")
  }

  def clickAndVerifyLog(target: JQuery, log: String): Unit = {
    click(target)
    waitResponse()
    verifyEquals(log, getZKLog)
    closeZKLog()
    waitResponse()
  }
  //copy from F86_ZK_3963Test - End
	@Test
	def testOrgitem(): Unit = {
    val zscript = """
     <include src="/test2/F86-ZK-3963.zul"/>
    """
		runZTL(zscript, () => {
			testItem3Selectable(findButtonByContent("setDisabled"))
			testItem3Selectable(findButtonByContent("setSelectable"))
			
			click(findButtonByContent("appendChild"))
			waitResponse()
			verifyTrue(findNodeByContent("newItem").exists())
			
			click(findButtonByContent("removeChild"))
			waitResponse()
			verifyFalse(findNodeByContent("newItem").exists())
			
			clickAndVerifyLog(isOpen, "true")
			click(findButtonByContent("setOpen"))
			waitResponse()
			clickAndVerifyLog(isOpen, "false")
			clickAndVerifyLog(getVisibleItemCount, "4")
			
			clickAndVerifyLog(isSelected, "false")
			click(findButtonByContent("setSelected"))
			waitResponse()
			clickAndVerifyLog(isSelected, "true")
			clickAndVerifyLog(getSelectedItem, "item3")
			
			clickAndVerifyLog(findButtonByContent("getLevel"), "1")
			clickAndVerifyLog(findButtonByContent("getParentItem"), "item1")
			clickAndVerifyLog(findButtonByContent("isContainer"), "true")
			clickAndVerifyLog(findButtonByContent("isEmpty"), "false")
		})
	}
	
	def testItem3Selectable(button: JQuery): Unit = {
		click(button)
		waitResponse()
		
		click(findNodeByContent("item3"))
		waitResponse()
		
		clickAndVerifyLog(isSelected, "false")
		
		click(button)
		waitResponse()
	}
}

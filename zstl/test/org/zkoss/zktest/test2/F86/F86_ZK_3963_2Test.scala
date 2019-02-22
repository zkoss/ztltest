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

class F86_ZK_3963_2Test extends ZTL4ScalaTestCase {
  //copy from F86_ZK_3963Test - Start
  val getSelectedItem = findButtonByContent("getSelectedItem()")
  val getItemCount = findButtonByContent("getItemCount()")
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
	def testByModel(): Unit = {
    val zscript = """
     <include src="/test2/F86-ZK-3963.zul"/>
    """
    runZTL(zscript, () => {
			click(findButtonByContent("remove3"))
			waitResponse()
			verifyFalse(findNodeByContent("item3").exists())
			clickAndVerifyLog(getItemCount, "3")
			
			click(findButtonByContent("add3"))
			waitResponse()
			verifyTrue(findNodeByContent("item3").exists())
			clickAndVerifyLog(getItemCount, "4")
			
			click(findButtonByContent("select3"))
			waitResponse()
			clickAndVerifyLog(isSelected, "true")
			clickAndVerifyLog(getSelectedItem, "item3")
			
			click(findButtonByContent("clearSelection"))
			waitResponse()
			clickAndVerifyLog(isSelected, "false")
			clickAndVerifyLog(getSelectedItem, "null")
			
			click(findButtonByContent("open3"))
			waitResponse()
			clickAndVerifyLog(isOpen, "true")
			clickAndVerifyLog(getItemCount, "7")
		})
	}
}

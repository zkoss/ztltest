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

class F86_ZK_3963Test extends ZTL4ScalaTestCase {
	val getSelectedItem = findButtonByContent("getSelectedItem()")
	val getItemCount = findButtonByContent("getItemCount()")
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
	
	@Test
	def testOrganigram(): Unit = {
		runZTL(() => {
			click(findButtonByContent("setSelectedItem(item3)"))
			waitResponse()
			clickAndVerifyLog(getSelectedItem, "item3")
			
			click(findButtonByContent("setSelectedItem(null)"))
			waitResponse()
			clickAndVerifyLog(getSelectedItem, "null")
			
			click(findNodeByContent("item1"))
			waitResponse()
			verifyEquals("onSelect: item1", getZKLog)
			closeZKLog()
			waitResponse()
			clickAndVerifyLog(getSelectedItem, "item1")
			clickAndVerifyLog(getItemCount, "9")
			clickAndVerifyLog(getVisibleItemCount, "9")
			
			click(findNodeByContent("item3").find(".z-orgnode-icon"))
			waitResponse()
			clickAndVerifyLog(getItemCount, "9")
			clickAndVerifyLog(getVisibleItemCount, "4")
			
			click(findButtonByContent("clear()"))
			waitResponse()
			clickAndVerifyLog(getItemCount, "0")
		})
	}
}

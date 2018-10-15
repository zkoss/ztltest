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

class F86_ZK_3963_2Test extends F86_ZK_3963Test {
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

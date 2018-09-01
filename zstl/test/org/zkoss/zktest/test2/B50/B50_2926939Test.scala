/* B50_2926939Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2926939Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					<html><![CDATA[
						<ol>
							<li>Click page button</li>
							<li>Check the number <b>inside dialog</b>, the left hand side number shall equal to the right hand side number</li>
						</ol>
					]]></html>
					Please check the paging number to see the result that the both number should be the same.
					<paging mold="os" pageSize="10" totalSize="100" onPaging='alert(event.getActivePage() + " : " + self.getActivePage());'/>
				</zk>
			"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      for (i <- 2 until 11) {
        click(jq(".z-paging-button:contains(" + i + ")"))
        waitResponse()
        var x = i - 1
        verifyEquals(x + " : " + x, jq(".z-messagebox-window .z-label").text())
        click(jq(".z-messagebox-window .z-button"))
        waitResponse()
      }
    })
  }
}




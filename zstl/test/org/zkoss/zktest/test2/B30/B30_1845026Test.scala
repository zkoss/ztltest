/* B30_1845026Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1845026Test extends ZTL4ScalaTestCase {
  @Test
  def testchangeLabel() = {
    runZTL(() => {
      var $txtbox = jq("$txtbox")
      var firstRow = jq("@treerow:eq(0)")
      clickAt(firstRow, "1,1"); //get selected
      waitResponse()
      clickAt(firstRow, "1,1"); //get selected
      waitResponse()
      focus($txtbox)
      typeKeys($txtbox, "a")
      waitResponse()
      clickAt(jq("@treerow:eq(1)"), "1,1")
      //when textbox onChange , the first row will be changed
      waitResponse()
      var rowText = firstRow.text()
      //"item 1 should be change to a but it is:"+ rowtext
      verifyTrue(rowText != null && rowText.indexOf("a") != -1)
    })
  }
}




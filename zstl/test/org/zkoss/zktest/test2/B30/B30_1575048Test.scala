/* B30_1575048Test.java

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

class B30_1575048Test extends ZTL4ScalaTestCase {
  @Test
  def testDelete() = {
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val userList = ztl$engine.$f("userList")
    val del = jq(".z-button:eq(0)")
    val itemId = ztl$engine.$f("itemId")
    val itemName = ztl$engine.$f("itemName")
    val add = jq(".z-button:eq(1)")
    runZTL(() => {
      click(userList.getChild("getBodyWidgetIterator().next()"))
      waitResponse()
      click(del)
      waitResponse()
      verifyEquals("2", userList.getChild("getBodyWidgetIterator().next()").attr("label"))
      var paging = userList.getChild("paging")
      verifyEquals("5", paging.attr("totalSize"))
      click(userList.getChild("getBodyWidgetIterator().next()"))
      waitResponse()
      click(del)
      waitResponse()
      verifyEquals("3", userList.getChild("getBodyWidgetIterator().next()").attr("label"))
      verifyEquals("4", paging.attr("totalSize"))
      verifyFalse(isVisible(paging))
      // Test adding
      typeKeys(itemId, "123")
      typeKeys(itemName, "123")
      click(add)
      waitResponse()
      click(paging.uuid() + "-next")
      waitResponse()
      verifyEquals("123", userList.lastChild().attr("label"))
      verifyEquals("5", paging.attr("totalSize"))
      verifyTrue(isVisible(paging))
    })
  }
}




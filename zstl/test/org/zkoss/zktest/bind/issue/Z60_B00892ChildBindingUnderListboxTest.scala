/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00892ChildBindingUnderListboxTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00892ChildBindingUnderListbox.zul"/>
    }

    runZTL(zul, () => {

      var outerbox = jq("$outerbox")

      var items = outerbox.find("@listitem")

      verifyEquals(4, items.length())

      var cell = items.eq(0).find("@listcell")
      verifyEquals(2, cell.length())
      verifyEquals("0", cell.eq(0).toWidget().get("label"))
      verifyEquals("A", cell.eq(1).toWidget().get("label"))

      cell = items.eq(1).find("@listcell")
      verifyEquals(2, cell.length())
      verifyEquals("1", cell.eq(0).toWidget().get("label"))
      verifyEquals("B", cell.eq(1).toWidget().get("label"))

      cell = items.eq(2).find("@listcell")
      verifyEquals(2, cell.length())
      verifyEquals("2", cell.eq(0).toWidget().get("label"))
      verifyEquals("C", cell.eq(1).toWidget().get("label"))

      cell = items.eq(3).find("@listcell")
      verifyEquals(2, cell.length())
      verifyEquals("3", cell.eq(0).toWidget().get("label"))
      verifyEquals("D", cell.eq(1).toWidget().get("label"))
    })
  }
}


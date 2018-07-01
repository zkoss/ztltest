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
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00604Test extends ZTL4ScalaTestCase {
  @Test
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B00604.zul"/>
"""

    runZTL(zul, () => {
      val inc1 = engine.$f("inc1")
      val inc2 = engine.$f("inc2")
      val listbox1 = jq(inc1).find("@listbox")
      val listbox2 = jq(inc2).find("@listbox")

      val itemLabel1 = Array("A", "B", "C")
      val itemLabel2 = Array("X", "Y", "Z")

      verifyTrue(listbox1.length() > 0)
      verifyTrue(listbox2.length() <= 0)
      var listbox = listbox1
      for (i <- 0 to 1) {
        val items = listbox.find("@listitem")
        verifyEquals(3, items.length())
        var item = items.first()
        for (j <- 0 to items.length() - 1) {
          val cell1 = item.children().first()
          val cell2 = cell1.next()
          verifyEquals(itemLabel1(j), cell1.toWidget().get("label"))
          verifyEquals(itemLabel2(j), cell2.toWidget().get("label"))
          item = item.next()
        }
        click(engine.$f("btn1"))
        waitResponse()
        listbox = jq(engine.$f("inc2")).find("@listbox")
      }
    })
  }
}
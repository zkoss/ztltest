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
import java.util.ArrayList

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00810ListboxMultipleTest extends ZTL4ScalaTestCase {

  def getSelectedIndexs(listbox: Widget): Any = {
    var list = new ArrayList[String]()
    var index = 0
    var w = listbox.firstChild() // maybe include header
    for (i <- 0 to listbox.nChildren() - 1) {
      if ("listitem".equals(w.eval("widgetName"))) {
        if (w.is("selected"))
          list.add(index + "")
        index = index + 1

      }
      w = w.nextSibling()
    }
    var indexes = new Array[String](list.size())
    for (i <- 0 to indexes.length - 1)
      indexes(i) = list.get(i).toString()
    indexes
  }

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00810ListboxMultiple.zul"/>
"""

    runZTL(zul, () => {
      var listbox1 = jq("$listbox1")
      var listbox2 = jq("$listbox2")
      var listbox3 = jq("$listbox3")
      var l1 = jq("$l1")
      var toggle = jq("$toggle")
      var update = jq("$update")
      click(listbox1.find("@listitem").eq(1).toWidget())
      waitResponse()
      verifyEquals(Array("1"), getSelectedIndexs(listbox1.toWidget()))
      verifyEquals(Array[String]("1"), getSelectedIndexs(listbox2.toWidget()))
      verifyEquals(Array[String]("1"), getSelectedIndexs(listbox3.toWidget()))
      verifyEquals("[1]", l1.toWidget().get("value"))
      click(listbox2.find("@listitem").eq(3).toWidget())
      waitResponse()
      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox1.toWidget()))
      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox2.toWidget()))
      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox3.toWidget()))
      verifyEquals("[1, 3]", l1.toWidget().get("value"))
      click(listbox3.find("@listitem").eq(6).toWidget())
      waitResponse()
      verifyEquals(Array[String]("1", "3", "6"), getSelectedIndexs(listbox1.toWidget()))
      verifyEquals(Array[String]("1", "3", "6"), getSelectedIndexs(listbox2.toWidget()))
      verifyEquals(Array[String]("1", "3", "6"), getSelectedIndexs(listbox3.toWidget()))
      verifyEquals("[1, 3, 6]", l1.toWidget().get("value"))
      click(toggle.toWidget())
      waitResponse()
      click(listbox3.find("@listitem").eq(7).toWidget())
      waitResponse()
      verifyEquals(Array[String]("7"), getSelectedIndexs(listbox1.toWidget()))
      verifyEquals(Array[String]("7"), getSelectedIndexs(listbox2.toWidget()))
      verifyEquals(Array[String]("7"), getSelectedIndexs(listbox3.toWidget()))
      verifyEquals("[7]", l1.toWidget().get("value"))
      click(listbox3.find("@listitem").eq(1).toWidget())
      waitResponse()
      verifyEquals(Array[String]("1"), getSelectedIndexs(listbox1.toWidget()))
      verifyEquals(Array[String]("1"), getSelectedIndexs(listbox2.toWidget()))
      verifyEquals(Array[String]("1"), getSelectedIndexs(listbox3.toWidget()))
      verifyEquals("[1]", l1.toWidget().get("value"))
//      click(listbox2.find("@listitem").eq(3).toWidget())
//      waitResponse()
//      click(toggle.toWidget())
//      waitResponse()
//      click(update.toWidget())
//      waitResponse()
//      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox1.toWidget()))
//      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox2.toWidget()))
//      verifyEquals(Array[String]("1", "3"), getSelectedIndexs(listbox3.toWidget()))
//      verifyEquals("[1, 3]", l1.toWidget().get("value"))
    })
  }
}

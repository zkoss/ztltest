
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
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00807GroupModel_2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00807GroupModelListbox.zul"/>
    }

    runZTL(zul, () => {

      var listbox = jq("$listbox")
      var groups = listbox.find("@listgroup")
      var groupfoots = listbox.find("@listgroupfoot")
      var items = listbox.find("@listitem")
      var l1 = jq("$l1")
      var sel1 = jq("$sel1")
      var sel2 = jq("$sel2")

      verifyEquals(3, groups.length())
      verifyEquals(3, groupfoots.length())
      verifyEquals(5, items.length())

      verifyEquals("Fruits", groups.eq(0).find("@listcell").toWidget().get("label"))
      verifyEquals("Seafood", groups.eq(1).find("@listcell").toWidget().get("label"))
      verifyEquals("Vegetables", groups.eq(2).find("@listcell").toWidget().get("label"))

      verifyEquals("1", groupfoots.eq(0).find("@listcell").toWidget().get("label"))
      verifyEquals("2", groupfoots.eq(1).find("@listcell").toWidget().get("label"))
      verifyEquals("2", groupfoots.eq(2).find("@listcell").toWidget().get("label"))

      verifyEquals("Apples", items.eq(0).find("@label").eq(1).toWidget().get("value"))
      verifyEquals("Salmon", items.eq(1).find("@label").eq(1).toWidget().get("value"))
      verifyEquals("Shrimp", items.eq(2).find("@label").eq(1).toWidget().get("value"))
      verifyEquals("Asparagus", items.eq(3).find("@label").eq(1).toWidget().get("value"))
      verifyEquals("Beets", items.eq(4).find("@label").eq(1).toWidget().get("value"))

      click(items.eq(4).toWidget())
      waitResponse()
      verifyEquals("Beets", l1.toWidget().get("value"))

      click(sel1.toWidget())
      waitResponse()
      verifyEquals("Apples", l1.toWidget().get("value"))

      click(sel2.toWidget())
      waitResponse()
      verifyEquals("Salmon", l1.toWidget().get("value"))

    })
  }
}

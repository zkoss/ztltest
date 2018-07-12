
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
class Z60_B00967GroupModel_1Test extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00967GroupModel.zul"/>
"""

    runZTL(zul, () => {

      var grid = jq("$grid")
      var groups = grid.find("@group")
      var groupfoots = grid.find("@groupfoot")
      var rows = grid.find("@row")

      verifyEquals(3, groups.length())
      verifyEquals(3, groupfoots.length())
      verifyEquals(5, rows.length())

      verifyEquals("Fruits", groups.eq(0).toWidget().attr("label"))
      verifyEquals("Seafood", groups.eq(1).toWidget().attr("label"))
      verifyEquals("Vegetables", groups.eq(2).toWidget().attr("label"))

      verifyEquals("1", groupfoots.eq(0).find("@label").toWidget().attr("value"))
      verifyEquals("2", groupfoots.eq(1).find("@label").toWidget().attr("value"))
      verifyEquals("2", groupfoots.eq(2).find("@label").toWidget().attr("value"))

      verifyEquals("Apples", rows.eq(0).find("@label").eq(1).toWidget().attr("value"))
      verifyEquals("Salmon", rows.eq(1).find("@label").eq(1).toWidget().attr("value"))
      verifyEquals("Shrimp", rows.eq(2).find("@label").eq(1).toWidget().attr("value"))
      verifyEquals("Asparagus", rows.eq(3).find("@label").eq(1).toWidget().attr("value"))
      verifyEquals("Beets", rows.eq(4).find("@label").eq(1).toWidget().attr("value"))

    })
  }
}
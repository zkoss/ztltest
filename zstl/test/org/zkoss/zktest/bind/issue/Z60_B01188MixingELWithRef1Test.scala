

/* Z60_B01188MixingELWithRef1Test.scala

	Purpose:
		
	Description:
		
	History:
		Jul 3, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01188MixingELWithRef1Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01188MixingELWithRef.zul"/>
"""
    runZTL(zul, () => {

      var lb = jq("$lb")

      var outerItems = lb.find("@listitem.outer")
      verifyEquals(2, outerItems.length())
      verifyEquals("Today", outerItems.eq(0).find("@listcell.outer @label").toWidget().attr("value"))
      verifyEquals("Tomorrow", outerItems.eq(1).find("@listcell.outer @label").toWidget().attr("value"))

      var innerItems = outerItems.eq(0).find("@listbox @listitem.inner")
      verifyEquals(2, innerItems.length())
      verifyEquals("Item 1", innerItems.eq(0).find("@listcell.inner @label").toWidget().attr("value"))
      verifyEquals("Item 2", innerItems.eq(1).find("@listcell.inner @label").toWidget().attr("value"))

      innerItems = outerItems.eq(1).find("@listbox @listitem.inner")
      verifyEquals(2, innerItems.length())
      verifyEquals("Item 3", innerItems.eq(0).find("@listcell.inner @label").toWidget().attr("value"))
      verifyEquals("Item 4", innerItems.eq(1).find("@listcell.inner @label").toWidget().attr("value"))

    })
  }
}

/* Z60_B01529SelectedItemsIndexTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01529SelectedItemsIndexTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01529SelectedItemsIndex.zul"/>
"""

    runZTL(zul, () => {

      var listbox = jq("$listbox")
      var lb = jq("$lb")

      var items = listbox.find("@listitem")

      click(items.eq(1).toWidget())
      waitResponse()
      verifyEquals("[1]", lb.toWidget().get("value"))

      click(items.eq(8).toWidget())
      waitResponse()
      verifyEquals("[1, 8]", lb.toWidget().get("value"))

      click(items.eq(9).toWidget())
      waitResponse()
      verifyEquals("[1, 8, 9]", lb.toWidget().get("value"))

      click(items.eq(4).toWidget())
      waitResponse()
      verifyEquals("[1, 8, 9, 4]", lb.toWidget().get("value"))

      click(items.eq(8).toWidget())
      waitResponse()
      verifyEquals("[1, 9, 4]", lb.toWidget().get("value"))

      click(items.eq(8).toWidget())
      waitResponse()
      verifyEquals("[1, 9, 4, 8]", lb.toWidget().get("value"))

      click(items.eq(1).toWidget())
      waitResponse()
      verifyEquals("[9, 4, 8]", lb.toWidget().get("value"))

      click(items.eq(2).toWidget())
      waitResponse()
      verifyEquals("[9, 4, 8, 2]", lb.toWidget().get("value"))

    })
  }
}

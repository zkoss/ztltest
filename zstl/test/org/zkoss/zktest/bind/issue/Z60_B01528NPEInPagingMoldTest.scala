/* Z60_B01528NPEInPagingMoldTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01528NPEInPagingMoldTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01528NPEInPagingMold.zul"/>
    }

    runZTL(zul, () => {

      var listbox = jq("$listbox")

      var items = listbox.find("@listitem")
      click(items.eq(9).toWidget())
      waitResponse()

      verifyEquals("Item 9", jq("$tb").toWidget().get("value"))

      click(jq("$delete").toWidget())
      waitResponse()

      var v = jq("$tb").toWidget().get("value")
      verifyTrue(v == null || v.equals(""))
      items = listbox.find("@listitem")

      verifyEquals(9, items.length())

    })
  }
}

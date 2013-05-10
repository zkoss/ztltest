/* Z60_B01528NPEInPagingMold2Test.scala

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
class Z60_B01528NPEInPagingMold2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01528NPEInPagingMold2.zul"/>
    }

    runZTL(zul, () => {

      var listbox = jq("$listbox")

      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("Item 0 Updated", listbox.find("@listitem").eq(0).find("@listcell").toWidget().get("label"))

      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("Item 2 Updated", listbox.find("@listitem").eq(2).find("@listcell").toWidget().get("label"))

      click(jq("$btn3").toWidget())
      waitResponse()
      verifyEquals("Item 5 Updated", listbox.find("@listitem").eq(5).find("@listcell").toWidget().get("label"))

      click(jq("$btn4").toWidget())
      waitResponse()
      verifyEquals("Item 9 Updated", listbox.find("@listitem").eq(9).find("@listcell").toWidget().get("label"))

    })
  }
}


/* Z60_B01344DeletingEntryTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01344DeletingEntryTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01344DeletingEntry.zul"/>
"""
    runZTL(zul, () => {

      var btn1 = jq("$btn1")
      for (i <- 10 to (0, -1) ) {
        verifyEquals("" + i, jq("$lb1").toWidget().get("value"))
        verifyEquals(i, jq("$listbox").find("@listitem").length())
        if (i > 0) {
          click(btn1.toWidget())
          waitResponse()
        }
      }

    })
  }
}

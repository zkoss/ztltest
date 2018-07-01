/* Z60_B01472BindIncludeArgTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01472BindIncludeArgTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01472BindIncludeArg.zul"/>
"""

    runZTL(zul, () => {

      var lb1 = jq("$lb1")
      var lb2 = jq("$lb2")

      var tb1 = jq("$tb1")
      var btn1 = jq("$btn1")

      verifyEquals("ABC", lb1.toWidget().get("value"))
      verifyEquals("ABC", lb2.toWidget().get("value"))

      `type`(tb1.toWidget(), "XYZ")
      waitResponse()
      click(btn1.toWidget())
      waitResponse()

      lb2 = jq("$lb2") //get again, it was changed
      verifyEquals("XYZ", lb1.toWidget().get("value"))
      verifyEquals("XYZ", lb2.toWidget().get("value"))

    })
  }
}


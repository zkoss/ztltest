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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00847FormInitTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00847FormInit.zul"/>
    }

    runZTL(zul, () => {

      var l1 = jq("$l1")
      var l2 = jq("$l2")

      var cmd1 = jq("$cmd1")
      var cmd2 = jq("$cmd2")

      verifyEquals("blue", l1.toWidget().get("value"))
      verifyEquals("blue", l2.toWidget().get("value"))

      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("red", l1.toWidget().get("value"))
      verifyEquals("blue", l2.toWidget().get("value"))

      click(cmd2.toWidget())
      waitResponse()
      verifyEquals("yellow", l1.toWidget().get("value"))
      verifyEquals("yellow", l2.toWidget().get("value"))

    })
  }
}
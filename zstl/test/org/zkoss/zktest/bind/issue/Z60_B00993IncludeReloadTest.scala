/* Z60_B00993IncludeReloadTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 20, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

/**
 * @author pao
 */

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00993IncludeReloadTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00993IncludeReload.zul"/>
"""

    runZTL(zul, () => {

      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var reload = jq("$reload")

      var val1 = l1.toWidget().get("value")
      var val2 = l2.toWidget().get("value")
      click(reload.toWidget())
      waitResponse()
      l1 = jq("$l1")
      l2 = jq("$l2")
      verifyNotEquals(val1, l1.toWidget().get("value"))
      verifyNotEquals(val2, l2.toWidget().get("value"))

      val1 = l1.toWidget().get("value")
      val2 = l2.toWidget().get("value")
      click(reload.toWidget())
      waitResponse()
      l1 = jq("$l1")
      l2 = jq("$l2")
      verifyNotEquals(val1, l1.toWidget().get("value"))
      verifyNotEquals(val2, l2.toWidget().get("value"))

      val1 = l1.toWidget().get("value")
      val2 = l2.toWidget().get("value")
      click(reload.toWidget())
      waitResponse()
      l1 = jq("$l1")
      l2 = jq("$l2")
      verifyNotEquals(val1, l1.toWidget().get("value"))
      verifyNotEquals(val2, l2.toWidget().get("value"))

      val1 = l1.toWidget().get("value")
      val2 = l2.toWidget().get("value")
      click(reload.toWidget())
      waitResponse()
      l1 = jq("$l1")
      l2 = jq("$l2")
      verifyNotEquals(val1, l1.toWidget().get("value"))
      verifyNotEquals(val2, l2.toWidget().get("value"))

    })
  }
}
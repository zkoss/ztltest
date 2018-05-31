/* Z60_B01017NestedFormPathTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01017NestedFormPathTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01017NestedFormPath.zul"/>
"""

    runZTL(zul, () => {

      var l11 = jq("$l11")
      var l12 = jq("$l12")

      var l21 = jq("$l21")
      var l22 = jq("$l22")

      var l31 = jq("$l31")
      var l32 = jq("$l32")

      var t1 = jq("$t1")
      var t2 = jq("$t2")
      var t3 = jq("$t3")

      var msg = jq("$msg")

      var update = jq("$update")

      verifyEquals("A", l11.toWidget().get("value"))
      verifyEquals("B", l21.toWidget().get("value"))
      verifyEquals("C", l31.toWidget().get("value"))

      verifyEquals("A", t1.toWidget().get("value"))
      verifyEquals("B", t2.toWidget().get("value"))
      verifyEquals("C", t3.toWidget().get("value"))

      `type`(t1.toWidget(), "Aa")
      waitResponse()
      verifyEquals("A", l11.toWidget().get("value"))
      verifyEquals("value is 'Aa'", l12.toWidget().get("value"))

      `type`(t2.toWidget(), "Bb")
      waitResponse()
      verifyEquals("B", l21.toWidget().get("value"))
      verifyEquals("value is 'Bb'", l22.toWidget().get("value"))

      `type`(t3.toWidget(), "Cc")
      waitResponse()
      verifyEquals("C", l31.toWidget().get("value"))
      verifyEquals("value is 'Cc'", l32.toWidget().get("value"))

      click(update.toWidget())
      waitResponse()
      verifyEquals("Aa", l11.toWidget().get("value"))
      verifyEquals("Bb", l21.toWidget().get("value"))
      verifyEquals("Cc", l31.toWidget().get("value"))

      verifyEquals("update value1:Aa,value2:Bb,value3:Cc", msg.toWidget().get("value"))
    })
  }
}

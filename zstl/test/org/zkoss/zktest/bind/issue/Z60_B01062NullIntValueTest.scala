/* Z60_B01062NullIntValueTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01062NullIntValueTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01062NullIntValue.zul"/>
"""

    runZTL(zul, () => {

      var lb11 = jq("$lb11")
      var lb12 = jq("$lb12")
      var lb21 = jq("$lb21")
      var lb22 = jq("$lb22")

      var msg1 = jq("$msg1")
      var msg2 = jq("$msg2")

      var save = jq("$save")

      verifyEquals("", lb11.toWidget().get("value"))
      verifyEquals("0", lb12.toWidget().get("value"))
      verifyEquals("", lb21.toWidget().get("value"))
      verifyEquals("0", lb22.toWidget().get("value"))

      click(save.toWidget())
      waitResponse()

      verifyEquals("", lb11.toWidget().get("value"))
      verifyEquals("0", lb12.toWidget().get("value"))
      verifyEquals("", lb21.toWidget().get("value"))
      verifyEquals("0", lb22.toWidget().get("value"))

      verifyEquals("value1 is null, value2 is 0", msg1.toWidget().get("value"))
      verifyEquals("value1 is null, value2 is 0", msg2.toWidget().get("value"))

    })
  }
}

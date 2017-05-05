/* Z60_F01046PublicEventTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F01046PublicEventTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01046PublicEvent.zul"/>
"""

    runZTL(zul, () => {

      var msg1 = jq("$msg1")
      var btn1 = jq("$btn1")
      var msg2 = jq("$msg2")
      var btn2 = jq("$btn2")

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("Hello i am a vm", msg2.toWidget().get("value"))

      click(btn2.toWidget())
      waitResponse()
      verifyEquals("Hello i am a composer", msg1.toWidget().get("value"))

    })
  }
}

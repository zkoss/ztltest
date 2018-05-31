/* Z60_F01032BindContextEventTest.scala

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
class Z60_F01032BindContextEventTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01032BindContextEvent.zul"/>
"""

    runZTL(zul, () => {

      var msg = jq("$msg")
      var tb = jq("$tb")
      var btn = jq("$btn")

      `type`(tb.toWidget(), "a")
      waitResponse()
      verifyEquals("evt1:onChange,evt2:onChange, cmd:cmd", msg.toWidget().get("value"))

      click(btn.toWidget())
      waitResponse()
      verifyEquals("evt1:onClick,evt2:onClick, cmd:cmd", msg.toWidget().get("value"))

    })
  }
}

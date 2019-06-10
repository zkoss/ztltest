/* B60_ZK_1053Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 12:34:17 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-1053
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-1053.zul,B,E,Selectbox,Chosenbox")
class B60_ZK_1053Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        var msg = jq("$msg")
        var sbx = jq("@selectbox")
        var cbx = jq("@chosenbox")
        var btn = jq("@button")

        click(sbx)
        waitResponse()
        verifyContains("You should see the msg become 'msg: Selectbox onFocus'",
          msg.html(), "msg: Selectbox onFocus")
        click(btn)
        waitResponse()
        verifyContains("You should see the msg become 'msg: Selectbox onBlur'",
          msg.html(), "msg: Selectbox onBlur")

        click(cbx)
        waitResponse()
        verifyContains("You should see the msg become 'msg: Chosenbox onFocus'",
          msg.html(), "msg: Chosenbox onFocus")
        click(btn)
        waitResponse()
        verifyContains("You should see the msg become 'msg: Chosenbox onBlur'",
          msg.html(), "msg: Chosenbox onBlur")
      }
    )
  }
}
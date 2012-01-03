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
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_DeferInitTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // deferinit.zul
      <zk>
        <window apply="org.zkoss.zktest.bind.basic.DeferInitVM">
        </window>
      </zk>
    }

    runZTL(zul, () => {
      var w1 = jq("$w1")
      var w2 = jq("$w2")
      var w1l11 = w1.find("$l11")
      var w1l12 = w1.find("$l12")
      var w1t11 = w1.find("$t11")
      var w1btn11 = w1.find("$btn11")
      var w1btn12 = w1.find("$btn12")
      var w1btn13 = w1.find("$btn13")
      var w1l21 = w1.find("$l21")
      var w1t21 = w1.find("$t21")
      var w1btn21 = w1.find("$btn21")
      var w2l11 = w2.find("$l11")
      var w2l12 = w2.find("$l12")
      var w2t11 = w2.find("$t11")
      var w2btn11 = w2.find("$btn11")
      var w2btn12 = w2.find("$btn12")
      var w2btn13 = w2.find("$btn13")
      var w2l21 = w2.find("$l21")
      var w2t21 = w2.find("$t21")
      var w2btn21 = w2.find("$btn21")
      verifyEquals("A", w1l11.toWidget().get("value"))
      verifyEquals("B", w1l12.toWidget().get("value"))
      verifyEquals("B", w1t11.toWidget().get("value"))
      verifyEquals("C:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      `type`(w1t11.toWidget(), "DD")
      waitResponse()
      verifyEquals("A", w1l11.toWidget().get("value"))
      verifyEquals("DD", w1l12.toWidget().get("value"))
      verifyEquals("DD", w1t11.toWidget().get("value"))
      verifyEquals("C:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w1btn11.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1l12.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1t11.toWidget().get("value"))
      verifyEquals("C:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w1btn12.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1l12.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w1btn13.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1l12.toWidget().get("value"))
      verifyEquals("DD:cmd1", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w1btn21.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("Y", w2l12.toWidget().get("value"))
      verifyEquals("Y", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      // test defer
      `type`(w2t11.toWidget(), "GG")
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("X", w2l11.toWidget().get("value"))
      verifyEquals("GG", w2l12.toWidget().get("value"))
      verifyEquals("GG", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w2btn11.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l11.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l12.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2t11.toWidget().get("value"))
      verifyEquals("Z:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:byForm", w2t21.toWidget().get("value"))
      click(w2btn12.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l11.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l12.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2t11.toWidget().get("value"))
      verifyEquals("Z:cmd2:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:cmd2:byForm", w2t21.toWidget().get("value"))
      click(w2btn13.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l11.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l12.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2t11.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm", w2t21.toWidget().get("value"))
      click(w2btn21.toWidget())
      waitResponse()
      verifyEquals("DD:cmd1", w1l11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1l21.toWidget().get("value"))
      verifyEquals("C:cmd2:cmd3:byForm", w1t21.toWidget().get("value"))
      verifyEquals("GG:cmd1", w2l11.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm:cmd4", w2l12.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm:cmd4", w2t11.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm", w2l21.toWidget().get("value"))
      verifyEquals("Z:cmd2:cmd3:byForm", w2t21.toWidget().get("value"))
    })
  }
}
/* B60_ZK_985Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 11:22:35 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-985
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-985.zul,A,E,Grid,onChanging")
class B60_ZK_985Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var btn: Widget = engine.$f("btn")
        var lb: Widget = engine.$f("lb")
        var tbx: Widget = engine.$f("tbx")

        `type`(tbx, "asdf")
        waitResponse()
        click(btn)
        waitResponse()
        verifyContains("Textbox should not be cleared", jq(lb).html(), "asdf")
      }
    );
  }
}

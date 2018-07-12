/* F60_ZK_468Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 16:47:21 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-468
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-468.zul,F60,A,E,Selectbox,Databinding,Model")
class F60_ZK_468Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var box: Widget = engine.$f("box")
      var _val: Widget = engine.$f("val")

      def selectItem(content: String) {
        select(box, content)
        waitResponse()
        verifyEquals("the label below should be changed as your selection",
          _val.$n().attr("innerHTML"), content)
      }

      selectItem("Tony")
      selectItem("Ryan")
      selectItem("Jumper")
      selectItem("Wing")
      selectItem("Sam")
    }
    )
  }
}
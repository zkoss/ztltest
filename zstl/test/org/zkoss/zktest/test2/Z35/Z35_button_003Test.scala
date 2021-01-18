/* Z35_button_003Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 11:09:24 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  * A test class for bug button-003
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z35-button-003.zul,Z35,A,E,Button")
@IgnoreBrowsers("ios,android")
class Z35_button_003Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {

        click(jq("$btn1"))
        waitResponse()
        verifyEquals(widget("$btn1").attr("label"), "OnClick OK")

        click(jq("$btn2"))
        waitResponse()
        verifyTrue(widget("$btn2").is("disabled"))

        contextMenu(jq("$btn3"))
        waitResponse()
        verifyEquals(widget("$btn3").attr("label"), "RightClick OK")

        doubleClick(jq("$btn4"))
        waitResponse()
        verifyEquals(widget("$btn4").attr("label"), "DoubleClick OK")

        focus(jq("$btn5"))
        waitResponse()
        verifyEquals(widget("$btn5").attr("label"), "Focused OK")

        click(jq("$btn6"))
        waitResponse()
        verifyEquals(widget("$btn6").attr("label"), "BlurMe")
        blur(jq("$btn6"))
        waitResponse()
        verifyEquals(widget("$btn6").attr("label"), "Blurred OK")

      }
    )
  }
}
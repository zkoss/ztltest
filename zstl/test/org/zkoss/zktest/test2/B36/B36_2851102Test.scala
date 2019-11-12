/* B36_2851102Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2851102
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2851102.zul,A,E,Window,Popup,Errorbox")
class B36_2851102Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        //Click 'Click Me' button
        val btn = jq("@toolbarbutton")
        click(btn)
        waitResponse()

        //Click textbox
        val txt = jq("@textbox")
        click(txt)
        waitResponse()

        //Click other place
        blur(txt)
        waitResponse()

        //Click close
        clickAt(jq(".z-errorbox").toWidget.$n("cls"), "2,2")
        waitResponse()

        //Window not closed
        verifyTrue(jq("$win1").isVisible)
      });
  }

}
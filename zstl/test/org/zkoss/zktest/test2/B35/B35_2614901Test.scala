/* B35_2614901Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 15, 2012 10:30:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author Fernando Selvatici
  *
  */
class B35_2614901Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      // Click on Project menu
      click(jq(".z-menu").get(0))
      waitResponse()

      val focusElement = jq(".z-menupopup").toWidget.$n("a")
      // Scroll up and down on the menu
      sendKeys(focusElement, Keys.DOWN)
      waitResponse()

      // Scroll up and down on the menu
      sendKeys(focusElement, Keys.DOWN)
      waitResponse()

      // Scroll up and down on the menu
      sendKeys(focusElement, Keys.DOWN)
      waitResponse()

      // Scroll up and down on the menu
      sendKeys(focusElement, Keys.UP)
      waitResponse()

      // Scroll up and down on the menu
      sendKeys(focusElement, Keys.UP)
      waitResponse()

      // Verify the correct selected item
      verifyContains("The selected item should be 'New'", jq(".z-menuitem-focus").text(), "New")
    })
  }
}

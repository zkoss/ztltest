/* B35_2465826Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 13, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2465826.zul,B,E,Window,Button")
class B35_2465826Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      waitResponse()
      // Click on second item
      var item = jq("@listitem").eq(1)
      click(item)
      waitResponse()

      // Record the selected item text
      val itemText = jq(".z-listitem-selected").text();

      verifyFalse("The selection cannot be empty", itemText.isEmpty());
      // Press enter key
      val focusElem =  jq("@listbox").toWidget().$n("a")
      sendKeys(focusElem, Keys.ENTER);

      waitResponse(true)
      // Verify that the messagebox is visible
      verifyTrue("The Messagebox should be visible", jq(".z-messagebox-window").exists());

      // Press enter key again
      sendKeys(jq("@button"), Keys.ENTER);

      // Verify that the selected item is the same as before
      verifyTrue("The selected item changed", itemText.equals(jq(".z-listitem-selected").text()));
    })
  }
}

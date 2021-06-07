/* B30_1984643Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 12, 2011 19:29:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1984643.zul,B,E,Window,Button")
@IgnoreBrowsers("ios,android")
class B30_1984643Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      click(jq("@select"))
      click(jq("option:contains(item 1)"));
      waitResponse();
      waitResponse();

      sendKeys(jq("@select"), Keys.ENTER);
      waitResponse();

      // Verify that the listbox is not visible
      verifyFalse("The Listbox should be invisible", jq("@select").isVisible());

    })
  }
}
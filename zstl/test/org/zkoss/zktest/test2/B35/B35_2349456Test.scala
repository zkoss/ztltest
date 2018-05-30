/* B35_2349456Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 17, 2012 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, ZK}

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2349456.zul,B,E,Window,Button")
class B35_2349456Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var listWidget =
        engine.$f("list");
      var listElement  =
        listWidget.$n("real");
      val a = if (isSafari) listWidget else listWidget.$n("a")

      // Click on first element of the list to verify later the final selected item
      click(jq(".z-listitem:contains(option 0)"));

      focus(a);

      // The following three commands doesn't work (Chrome/Firefox). The selected does not change.
//      sendKeys(listWidget, Keys.ARROW_DOWN);
//      keyPress(listWidget, "\\28");
      sendKeys(a, Keys.DOWN);
      waitResponse();

      // Press the DOWN key
      sendKeys(a, Keys.DOWN);

      // Press the DOWN key
      sendKeys(a, Keys.DOWN);

      // Press the DOWN key
      sendKeys(a, Keys.DOWN);

      // Press the UP key
      sendKeys(a, Keys.UP);

      // Press the UP key
      sendKeys(a, Keys.UP);
      
      // After DOWN+DOWN+DOWN+UP+UP the selected item should be "Option 2"
    	  verifyTrue("The selected item should be 'option 2'", jq(".z-listitem-selected").text().contains("option 2"));

    })
  }
}

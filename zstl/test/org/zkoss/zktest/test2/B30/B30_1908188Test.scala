/* B30_1908188Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 23, 2011 10:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1908188.zul,B,E,Window,Button")
class B30_1908188Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      // Record Menu position
      var xMenu: Int = jq("$testMenu").positionLeft();
      var yMenu: Int = jq("$testMenu").positionTop();

      // Click on the menu
      click(jq("$testMenu"));

      waitResponse();

      // Click of first menu item
      click(jq(".z-menuitem").get(0));

      waitResponse();

      // Record Popup position
      var x: Int = jq(".z-popup").positionLeft()
      var y: Int = jq(".z-popup").positionTop()

      // Verify that the popup is below the test menu. It may fail if the browser is sized with a small height and width
      verifyTrue("The popup must be at right and below of the menu", x > xMenu && y > yMenu);

      // Click on the menu
      click(jq("$testMenu"));

      waitResponse();

      // Click of second menu item
      click(jq(".z-menuitem").get(1));

      waitResponse();
      // Record Popup position
      x = jq(".z-popup").positionLeft()
      y = jq(".z-popup").positionTop()

      // Verify that the popup is in position (50,50). 
      verifyTrue("The popup must be at position (50,50)", x == 50 && y == 50);

    })
  }
}

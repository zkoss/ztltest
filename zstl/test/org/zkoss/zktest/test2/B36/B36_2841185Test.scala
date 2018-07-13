/* B36_2841185Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jun 11, 2012 11:30:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B36-2841185.zul,B,E,Window,Button")
class B36_2841185Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      // Click paging field
      click(jq(".z-paging-input"));
      waitResponse();

      // Remove the value '1'
      sendKeys(jq(".z-paging-input"), Keys.BACK_SPACE);
      waitResponse();

      // Insert value '2'
      sendKeys(jq(".z-paging-input"), "2");
      waitResponse();

      // Press Enter key
      sendKeys(jq(".z-paging-input"), Keys.ENTER);
      waitResponse();

      // Verify that the grid exists
      verifyTrue("The grid should be visible", jq(".z-grid").isVisible());
    })
  }
}
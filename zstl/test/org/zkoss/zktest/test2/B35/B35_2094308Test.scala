/* B35_2094308Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2094308.zul,B,E,Window,Button")
class B35_2094308Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      // Set the top value
      sendKeys(engine.$f("top"), "200");
      waitResponse();
      // Set the left value
      sendKeys(engine.$f("left"), "300");
      waitResponse();
      // Click on save button
      click(engine.$f("save"));
      waitResponse();

      // Verify there is no javascript error
      verifyFalse(jq(".z-error").exists());
    })
  }
}
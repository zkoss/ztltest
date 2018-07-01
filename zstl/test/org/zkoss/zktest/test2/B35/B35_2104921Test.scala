/* B35_2104921Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 17, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2104921.zul,B,E,Window,Button")
class B35_2104921Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var eastBtn = jq("$e")
      var westBtn = jq("$w")
      // Click on the east button
      click(jq(eastBtn.toWidget().$n("btn")))
      waitResponse(true);
      // Click on the west button
      click(jq(westBtn.toWidget().$n("btn")))
      waitResponse(true);

      // Click on the East bar
      click(jq(eastBtn.toWidget().$n("colled")))
      waitResponse(true);

      // Verify the css style of the east zone. If the style contains the display attribute setted to block, it is visible
      verifyTrue("The east zone should be visible", jq("@east").eq(1).isVisible());

      // Click on the West bar
      click(jq(westBtn.toWidget().$n("colled")))
      waitResponse(true);

      // Verify the css style of the east zone. If the style contains the display attribute setted to none, 
      // it is not visible. So it is correct
      verifyFalse("The east zone should be collapsed", jq(".z-east").eq(1).isVisible());
    })
  }
}
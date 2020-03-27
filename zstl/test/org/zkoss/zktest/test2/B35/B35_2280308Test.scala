/* B35_2280308Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  */
@Tags(tags = "B35-2280308.zul,B,E,Window,Button")
class B35_2280308Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      // Scroll the panelchildren
      val pc = jq("@panelchildren");
      verScrollAbs(pc, pc.scrollHeight())
      waitResponse();
      // Click on submit button
      click(jq(".z-button"));
      waitResponse();
      verifyTrue("It should be visible an error box", jq(".z-errorbox").exists());
    })
  }
}
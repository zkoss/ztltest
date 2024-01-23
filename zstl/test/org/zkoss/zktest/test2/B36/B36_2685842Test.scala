/* B36_2685842Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B36_2685842Test extends ZTL4ScalaTestCase {
  @Test
  def testTitleCorner() = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-window:contains(My First Window)").exists())
      verifyTrue(jq(".z-panel:contains(My First Panel)").exists())
    })
  }
}
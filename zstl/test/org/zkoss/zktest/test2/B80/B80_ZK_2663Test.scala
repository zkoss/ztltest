/* B80_ZK_2663Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B80_ZK_2663Test extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    runZTL(() => {
      click(jq(".z-button"))
      waitResponse()
      verifyEquals("block", jq(".z-popup").css("display"))
    })
  }
}




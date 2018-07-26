/* B60_ZK_1338Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thur. September 6 17:22:35 CST 2012 , Created by jumperchen
}}IS_NOTE

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-1338
  *
  * @author jumperchen
  *
  */
@Tags(tags = "B60-ZK-1338.zul,A,E,ClientEngine,Javascript")
class B60_ZK_1338Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      sleep(5000);
      waitResponse();

      verifyTrue("Window should be there!", engine.$f("mainWin").exists())
      click(jq("@button"))
      waitResponse();
    })
  }
}
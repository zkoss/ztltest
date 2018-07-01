/* B30_2208873Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 1, 2011 05:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2208873.zul,B,E,Window,Button")
class B30_2208873Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      // Verifying each of the cells
      verifyEquals("Items should be visible", 4, jq(".z-listcell").length());
    })
  }
}
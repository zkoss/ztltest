/* B30_1876252Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1876252Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      var rowHeight = jq(".z-listitem").height()
      //make sure the row height in second listbox is same as first.
      verifyEquals(rowHeight, jq(".z-listitem:eq(1)").height())
      //breeze ie8's height will bigger then listrow for 2px .
      //I am not sure it's a spec or not.
      verifyTolerant(rowHeight, jq(".z-listbox:eq(0)").height(), 2)
      //something the rowHeight will be odd, so have a tolerant 1.
      verifyTolerant(rowHeight * 2, jq(".z-listbox:eq(1)").height(), 2)
    })
  }
}




/* B36_2799258Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B36_2799258Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollbar() = {
    runZTL(() => {
      var header = jq("@listheader:eq(0)")
      var x = header.outerWidth()
      dragdropTo(header, x + ",0", (x + 500) + ",0")
      var body = jq(jq("@listbox").toWidget().$n("body"))
      var bodyHeight = body.innerHeight()
      var caveHeight = body.find("table").outerHeight()
      verifyTrue(bodyHeight >= caveHeight)
    })
  }
}




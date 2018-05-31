/* B50_2986905Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2986905Test extends ZTL4ScalaTestCase {
  @Test
  def testvalue() = {
    var zscript =
      """
			<listbox name="lb" mold="select">
	 			<listitem id="li" label="label" value="value"/>	 		
	 		</listbox>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val li = ztl$engine.$f("li")
    runZTL(zscript, () => {
      verifyEquals("value", jq(li).`val`())
    })
  }
}




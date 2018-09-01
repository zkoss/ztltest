/* B35_2480892Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2480892Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
				<zscript>
				String[] values = new String[] {"Red", "Blue", "Purple"};
				</zscript>
			
			You shall see three textbox components below. The value of them shall be
			Red, Blue and Purple, respectively.
			
			<ol xmlns="http://www.zkoss.org/2005/zk/native"
			xmlns:u="http://www.zkoss.org/2005/zul">
				<li forEach="${values}"><u:textbox value="${each}"/></li>
			</ol>	
			</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals("Red", jq(".z-textbox:eq(0)").`val`())
      verifyEquals("Blue", jq(".z-textbox:eq(1)").`val`())
      verifyEquals("Purple", jq(".z-textbox:eq(2)").`val`());
    })
  }
}




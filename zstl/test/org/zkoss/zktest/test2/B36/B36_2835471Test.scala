/* B36_2835471Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2835471Test extends ZTL4ScalaTestCase {
  @Test
  def testtitle() = {
    var zscript =
      """
			<panel title="My First Window" border="normal" width="250px">
			<caption label="Hello, World!"/>
			<panelchildren>
			You should see the title is "My First Window - Hello, World!"
			</panelchildren>
			</panel>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("My First Window - Hello, World!", jq("@caption").text())
    })
  }
}




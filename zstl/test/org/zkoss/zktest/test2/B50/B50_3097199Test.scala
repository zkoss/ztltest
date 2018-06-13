/* B50_3097199Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3097199Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
			<zk>
				<combobox id="cb" constraint="strict:Please select">
					<comboitem label="Simple and Rich"
						description="The simplest way to make Web applications rich" />
					<comboitem label="Cool!" description="The coolest technology" />
					<comboitem label="Ajax and RIA"
						description="Rich Internet Application by Ajax" />
				</combobox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      var inp = cb.$n("real")
      typeKeys(inp, "Test")
      keyPress(inp, "\\9")
      verifyTrue(jq(".z-errorbox").exists())
      verifyEquals("Please select", jq(".z-errorbox-content").html())
    })
  }
}




/* B30_1920751Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1920751Test extends ZTL4ScalaTestCase {
  @Test
  def testcombobox() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Please type the word "s" into the input element, and then press the "Down" button, and the item "Cool!" should be shown.</n:p>
				<combobox id="cb1" constraint="strict">
					<comboitem label="Simple and Rich" disabled="true"/>
					<comboitem label="Cool!"/>
					<comboitem label="Thumbs Up!" disabled="true"/>
					<comboitem label="ZK Best!"/>
					<comboitem label="ZK Best1 ! " disabled="true"/>
				</combobox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    runZTL(zscript, () => {
      click(cb1.$n("real"));
      waitResponse()
      sendKeys(cb1.$n("real"), Keys.DOWN);
      waitResponse()
      verifyEquals("Cool!", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
    })
  }
}




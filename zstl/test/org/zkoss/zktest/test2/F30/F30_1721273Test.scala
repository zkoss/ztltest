/* F30_1721273Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class F30_1721273Test extends ZTL4ScalaTestCase {
  @Test
  def testEvent() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1721273 ] Event Enachment</n:h2>
			<n:ol>
				<n:li>Focus into the textbox, then you press the "Enter" key, you will see alert message</n:li>
			</n:ol>
			<textbox id="tb1" value="Support onOK event 1" onOK="alert(self.value);"/>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb1 = ztl$engine.$f("tb1")
    runZTL(zscript, () => {
      verifyFalse(jq("@window").exists())
      focus(tb1)
      sendKeys(tb1, Keys.ENTER)
      waitResponse()
      verifyTrue(jq("@window").exists())
    })
  }
}




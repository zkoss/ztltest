/* B50_2916148Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2916148Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
Please focus in and out, and click the close sign (X), the errorbox should
be closed.
<textbox id="tb" constraint="no empty"/>
</zk>
			"""
    val ztl$engine = engine()
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      var eb = jq(".z-errorbox")
      focus(tb)
      waitResponse()
      blur(tb)
      waitResponse()
      verifyTrue(eb.exists())
      waitResponse()
      click(eb.toWidget().$n("cls"))
      waitResponse()
      if (eb.exists()) // selenium issue
        click(eb.toWidget().$n("cls"))
      waitResponse()
      verifyFalse(eb.exists());
    })
  }
}




/* B50_3087421Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3087421Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html>
		<![CDATA[
			<ol>
			<li>Click both button, it will disable, after processing, it will re-enable</li>
			</ol>
		]]>
	</html>
	<button id="btn" label="click" autodisable="self" onClick='org.zkoss.lang.Threads.sleep(3000);'/>
	<toolbarbutton id="btn1" label="click" autodisable="self"  onClick='org.zkoss.lang.Threads.sleep(3000);'/>
</zk>

		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val btn1 = ztl$engine.$f("btn1")
    runZTL(zscript, () => {
      verifyFalse(btn.is("disabled"))
      click(btn)
      sleep(500)
      verifyTrue(btn.is("disabled"))
      sleep(3000)
      verifyFalse(btn.is("disabled"))
      click(btn1)
      sleep(500)
      verifyTrue(btn1.is("disabled"))
      sleep(3000)
      verifyFalse(btn1.is("disabled"))
    })
  }
}




/* B30_1881573Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1881573Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
  <n:p>	IE6 only: You shall see scrollbar after clicking the 100 button.</n:p>
  <window id="t" title="sizing test" contentStyle="overflow:auto;background:pink" width="250px">
	<hbox>
	<button id="btn" label="100" onClick='t.height = "100px"'/>
	<button label="200" onClick='t.height = "200px"'/>
	<button label="300" onClick='t.height = "300px"'/>
	</hbox>
	<div height="100px">abc</div>
  </window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t = ztl$engine.$f("t")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      var $cave = jq(t.$n("cave"))
      click(btn)
      waitResponse()
      $cave.toElement().set("scrollTop", 50)
      verifyNotEquals("0px", $cave.css("scrollTop"))
    })
  }
}




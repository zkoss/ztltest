/* B50_3165081Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3165081Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk>
	<html><![CDATA[
		<ol>
			<li>Try to drag all 4 splitters, you should not be able to move any of them.</li>
		</ol>
	]]></html>
	<hbox width="200px" height="200px">
		<splitter id="s1"/>
		Content
		<splitter id="s2"/>
	</hbox>
	<vbox width="200px" height="200px">
		<splitter id="s3"/>
		Content
		<splitter id="s4"/>
	</vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val s1 = ztl$engine.$f("s1")
    val s2 = ztl$engine.$f("s2")
    val s3 = ztl$engine.$f("s3")
    val s4 = ztl$engine.$f("s4")
    runZTL(zscript, () => {
      var s1l = getElementPositionLeft(s1).intValue()
      var s2l = getElementPositionLeft(s2).intValue()
      var s3t = getElementPositionTop(s3).intValue()
      var s4t = getElementPositionTop(s4).intValue()
      dragdropTo(s1, "0,0", "30,0")
      dragdropTo(s2, "0,0", "30,0")
      dragdropTo(s3, "0,0", "0,30")
      dragdropTo(s4, "0,0", "0,30")
      verifyEquals(s1l, getElementPositionLeft(s1).intValue())
      verifyEquals(s2l, getElementPositionLeft(s2).intValue())
      verifyEquals(s3t, getElementPositionTop(s3).intValue())
      verifyEquals(s4t, getElementPositionTop(s4).intValue())
    })
  }
}




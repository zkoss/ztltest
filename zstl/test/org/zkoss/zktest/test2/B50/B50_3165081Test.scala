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
import org.zkoss.ztl.unit.Widget


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
    val ztl$engine = engine()
    val s1 = ztl$engine.$f("s1")
    val s2 = ztl$engine.$f("s2")
    val s3 = ztl$engine.$f("s3")
    val s4 = ztl$engine.$f("s4")
    runZTL(zscript, () => {
      var s1l = jq(s1).positionLeft()
      var s2l = jq(s2).positionLeft()
      var s3t = jq(s3).positionTop()
      var s4t = jq(s4).positionTop()
      dragdropTo(s1, "0,0", "30,0")
      dragdropTo(s2, "0,0", "30,0")
      dragdropTo(s3, "0,0", "0,30")
      dragdropTo(s4, "0,0", "0,30")
      verifyEquals(s1l, jq(s1).positionLeft())
      verifyEquals(s2l, jq(s2).positionLeft())
      verifyEquals(s3t, jq(s3).positionTop())
      verifyEquals(s4t, jq(s4).positionTop())
    })
  }
}




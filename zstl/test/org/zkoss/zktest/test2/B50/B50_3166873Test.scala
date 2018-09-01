/* B50_3166873Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3166873Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Try to drag the splitters. If either one can't be moved, it is a bug.</li>
		</ol>
	]]></html>
	<hlayout>
		<window border="normal" width="250px" height="250px" title="Hbox">
			<hbox hflex="1" vflex="1">
				Content
				<splitter id="s1"/>
				Content
			</hbox>
		</window>
		<window border="normal" width="250px" height="250px" title="Vbox">
			<vbox hflex="1" vflex="1">
				Content
				<splitter id="s2"/>
				Content
			</vbox>
		</window>
	</hlayout>
</zk>

		"""
    val ztl$engine = engine()
    val s1 = ztl$engine.$f("s1")
    val s2 = ztl$engine.$f("s2")
    runZTL(zscript, () => {
      var left = jq(s1).positionLeft()
      var top = jq(s2).positionTop()
      dragdropTo(s1, "3,3", "13,3")
      dragdropTo(s2, "3,3", "3,13")
      verifyNotEquals(left, jq(s1).positionLeft())
      verifyNotEquals(top, jq(s2).positionTop())
    })
  }
}




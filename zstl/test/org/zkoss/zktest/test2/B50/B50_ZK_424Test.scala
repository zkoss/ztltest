/* B50_ZK_424Test.java

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


class B50_ZK_424Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk xmlns:n="native">
				You should see "111" at the bottom of the inputbox, rather than "333"
				<n:div id="hi">
					<window>
						<textbox id="textbox1" />
					</window>
				</n:div>
				<n:div id="hi2">
					<window>
						<textbox id="textbox2" />
					</window>
				</n:div>
				<n:div id="hi3">
					<window>
						<textbox id="textbox3" />
					</window>
				</n:div>
				<label id="msg"/>
				<script>
				zk.afterMount(function(){ jq("$msg").html("" +jq("#hi").find("$textbox1").size() + jq("#hi2").find("$textbox2").size() + jq("#hi3").find("$textbox3").size()); });
				</script>
				
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val hi = ztl$engine.$f("hi")
    val textbox1 = ztl$engine.$f("textbox1")
    val hi2 = ztl$engine.$f("hi2")
    val textbox2 = ztl$engine.$f("textbox2")
    val hi3 = ztl$engine.$f("hi3")
    val textbox3 = ztl$engine.$f("textbox3")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      verifyEquals("111", msg.$n().attr("innerHTML"))
    })
  }
}




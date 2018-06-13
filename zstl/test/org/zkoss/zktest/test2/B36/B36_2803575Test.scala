/* B36_2803575Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2803575Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabind() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" arg0="./mywin"?>
			<window id="mywin" border="none">
			<html><![CDATA[
			<ol>
			<li>You shall see a blue "Hello ZK".</li>
			<li>Now press the "Change"</li>
			<li>You shall see "Hello ZK" turn to red color; otherwise, it is bug.</li>
			</ol>
			]]></html>
			<zscript>
			    String hello= "Hello ZK";
				String s1 = "color:blue";
			</zscript>
			<label id="label1" value="@{hello, x1='color:red'}" style="@{s1,load-when='btn.onClick'}"/>
			<button id="btn" label="Change">
				<attribute name="onClick">
					Map map = label1.getAttribute("bindingArgs");
					if (map != null) {
						String s2= map.get("x1");
						if (s2 != null) {
							label1.setStyle(s2);
						}
					}
				</attribute>
			</button>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val mywin = ztl$engine.$f("mywin")
    val label1 = ztl$engine.$f("label1")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyTrue("Color is : " + jq("$label1").css("color"), "rgb(0, 0, 255)blue#0000ff".indexOf(jq("$label1").css("color")) > -1)
      click(jq("$btn"))
      waitResponse()
      verifyTrue("Color is : " + jq("$label1").css("color"), "rgb(255, 0, 0)red#ff0000".indexOf(jq("$label1").css("color")) > -1)
    })
  }
}




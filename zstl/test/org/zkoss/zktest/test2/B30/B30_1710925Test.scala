/* B30_1710925Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1710925Test extends ZTL4ScalaTestCase {
  @Test
  def testStyle() = {
    var zscript =
      """
			<window id="w" title="Test of the style component">
				Bug 1710925: you shall see the background color changed when
				pressing the buttons in order.
			        <separator/>
			        The 3rd botton work slow in IE6, IE7 and doesn't work in SA, it won't fixed.
			        <separator/>
				<button id="btn1" label="1. change background to yellow">
					<attribute name="onClick">{
				Style s = new Style();
				s.setContent("body {background: yellow}");
				s.setId("style");
				s.setDynamic(true);
				s.setParent(w);
					}</attribute>
				</button>
				<button id="btn2" label="2. change background to blue">
					<attribute name="onClick">
					style.setContent("body {background: blue}");
					</attribute>
				</button>
				<button id="btn3" label="3. remove the background">
					<attribute name="onClick">
				style.detach();
					</attribute>
				</button>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val w = ztl$engine.$f("w")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val style = ztl$engine.$f("style")
    runZTL(zscript, () => {
      click(btn1)
      waitResponse()
      var color = jq("body").css("backgroundColor")
      verifyTrue("rgb(255, 255, 0)#ffff00".contains(color) || "yellow".equals(color))
      click(btn2)
      waitResponse()
      color = jq("body").css("backgroundColor")
      verifyTrue("rgb(0, 0, 255)#0000ff".contains(color) || "blue".equals(color))
    })
  }
}




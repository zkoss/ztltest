/* B50_2970460Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2970460Test extends ZTL4ScalaTestCase {
  @Test
  def testSize() = {
    var zscript =
      """
			<window id="win" border="normal" sizable="true" onMaximize="onMaximizeWin()"
					title="eee" width="600px" minheight="300" height="300px" maximizable="true" closable="true">
				<zscript>
					<![CDATA[
						void onMaximizeWin() {
					top.value = win.top;
					left.value = win.left;
					height.value = win.height;
					width.value = win.width;		
				}
					]]>
				</zscript>
				<label id="top"/>
				<label id="left"/>
				<label id="height"/>
				<label id="width"/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val top = ztl$engine.$f("top")
    val left = ztl$engine.$f("left")
    val height = ztl$engine.$f("height")
    val width = ztl$engine.$f("width")
    runZTL(zscript, () => {
      var t: String = win.get("top")
      var l: String = win.get("left")
      var h: String = win.get("height")
      var w: String = win.get("width")
      win.set("maximized", true)
      waitResponse()
      var curTop = win.get("top")
      var curLeft = win.get("left")
      if (!t.equals(curTop))
        verifyTrue(t.equals("") && curTop.equals("0px"))
      if (!l.equals(curLeft))
        verifyTrue(l.equals("") && curLeft.equals("0px"))
      verifyNotEquals(h, win.get("height"))
      verifyNotEquals(w, win.get("width"))
      win.set("maximized", false)
      verifyEquals(h, win.get("height"))
      verifyEquals(w, win.get("width"))
    })
  }
}




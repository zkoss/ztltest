/* B50_3147909Test.java

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
import org.zkoss.ztl.Widget


class B50_3147909Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk>
	<html><![CDATA[
		<ol>
			<li>Click on both listboxes. Their drop down should appear normally.</li>
			<li>Drag the inner Div. Only the inner Div part should move.</li>
			
			<b>Note. when you drag the inner Div, you shall only drag the light blue area, if also drag brown area, that 's bug </b>
		</ol>
	]]></html>
	<div draggable="true" style="background: #CCCC99" width="200px">
		<listbox mold="select">
			<listitem label="A1" />
			<listitem label="A2" />
		</listbox>
		<div id="inner" draggable="true" style="background: #99CCCC" width="100px">Inner Div</div>
	</div>
	<listbox mold="select" draggable="true">
		<listitem label="B1" />
		<listitem label="B2" />
	</listbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val inner = ztl$engine.$f("inner")
    runZTL(zscript, () => {
      mouseMoveAt(jq(inner), "3,3");
      waitResponse()
      mouseDownAt(jq(inner), "3,3");
      waitResponse()
      mouseMoveAt(jq(inner), "10,3");
      waitResponse()
      verifyTolerant(jq(inner).height(), getElementHeight(jq(".z-drag-ghost")).intValue(), 1)
      verifyTolerant(100, getElementWidth(jq(".z-drag-ghost")).intValue(), 1)
      mouseUpAt(jq(inner), "10,3");
      waitResponse()
    })
  }
}




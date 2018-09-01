/* B50_3021174Test.java

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


class B50_3021174Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
   <html><![CDATA[
	<ul>
	<li>Click "show popup window" shall not cause js error</li>
	</ul>
	]]></html>
	<button id="btn" label="click" >
		<attribute name="onClick"><![CDATA[
			createEvent.setLeft("100px");
			createEvent.visible = true;
		]]></attribute>
	</button>
	<window width="400px" title="Create Event" border="normal"
			id="createEvent" mode="popup" visible="false"  closable="true"/>
</zk>

		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val createEvent = ztl$engine.$f("createEvent")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}




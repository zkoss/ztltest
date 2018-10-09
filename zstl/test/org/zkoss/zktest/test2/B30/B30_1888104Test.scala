/* B30_1888104Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1888104Test extends ZTL4ScalaTestCase {
  @Test
  def testZIndex() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:ol>
					<n:li>press click me.</n:li>
					<n:li>click into the intbox and enter a positive number, say, 5.</n:li>
					<n:li>[IE,FF,SA]tab away,([Opera]Unfocus the intbox)  and the error message is shown and it should be "ABOVE" the popup.(Use Safari version 3.0.4 or later)</n:li>
				</n:ol>
				<window id="mainWindow">
					<label id="clickLbl" value="click me" popup="mypopup" />
					<popup id="mypopup" style="border: visible">
						<window width="200px">
							<intbox id="myIntbox" constraint="no positive" value="0"/>
						</window>
					</popup>
				</window>
			</zk>
		"""
    val ztl$engine = engine()
    val mainWindow = ztl$engine.$f("mainWindow")
    val clickLbl = ztl$engine.$f("clickLbl")
    val mypopup = ztl$engine.$f("mypopup")
    val myIntbox = ztl$engine.$f("myIntbox")
    runZTL(zscript, () => {
      click(clickLbl)
      waitResponse()
      verifyTrue(jq(mypopup).height() > 0)
      focus(myIntbox)
      waitResponse()
      typeKeys(myIntbox, "5")
      waitResponse(true)
      sleep(300)
      var errbox = jq(".z-errorbox")
      verifyTrue(errbox.exists())
      var errboxZIdx = parseInt(errbox.css("z-index"))
      var popupZIdx = parseInt(jq(mypopup).css("z-index"))
      verifyTrue(errboxZIdx > popupZIdx)
    })
  }
}




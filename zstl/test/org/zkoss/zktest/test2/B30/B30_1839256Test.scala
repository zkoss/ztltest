/* B30_1839256Test.java

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


class B30_1839256Test extends ZTL4ScalaTestCase {
  @Test
  def testGettingResponse() = {
    var zscript =
      """
				<zk>
					<window title="Test of long operation">
						Clicks the Test button and you shall see alert after 10 seconds (Bug 1839256).
						To verify bug 1907640, test this file with Glassfish.
						<separator/>
						Moreover, all following clicks are ignored before alert is shown (Feature 1859533).
						<separator/>
						<button label="Test" autodisable="self">
							<attribute name="onClick">
							org.zkoss.lang.Threads.sleep(10000);
							alert("Everything goes fine");
							</attribute>
						</button>
					</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq(".z-button"))
      waitResponse()
      if (jq(".z-window-highlighted").exists() || jq(".z-window-modal").exists()) {
        verifyTrue(true)
      } else {
        verifyTrue(false)
      }
    })
  }
}




/* B50_3013538Test.java

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


class B50_3013538Test extends ZTL4ScalaTestCase {
  @Test
  def testreloadMessages() = {
    var zscript =
      """
			<zk>
				Click the button, if doesn't show error message below, it's correct
				<div></div>
				<button id="btn" label="Reload Message">
					<attribute name="onClick">
						try {
							Clients.reloadMessages(null);
					      } catch (Exception e) {
					    	msg.setValue(e.getMessage());
					    }
					</attribute>
				</button>
				<label id="msg" style="color: red;"></label>
			</zk>
		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyEquals(msg.attr("value"), "")
    })
  }
}




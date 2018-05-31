/* B30_1593674Test.java

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


class B30_1593674Test extends ZTL4ScalaTestCase {
  @Test
  def testRightClick() = {
    var zscript =
      """
			<groupbox onClick="" xmlns:h="http://www.w3.org/1999/xhtml">
				<caption label="User Information"/>
				<h:form action="service.zul">
					<h:input type="submit" value="Submit"/>
				</h:form>
			</groupbox>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyTrue(jq(":submit").exists())
      click(jq(":submit"));
      sleep(1000)
      verifyFalse(jq("div.z-error").exists());
    })
  }
}




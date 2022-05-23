/* B50_ZK_692Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 20 10:41:47 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{SeleniumOnly, Tags};

/**
  *
  * @author jumperchen
  */
@Tags(tags = "B50-ZK-692.zul,B,M,RemoveDesktop")
@SeleniumOnly
class B50_ZK_692Test extends ZTL4ScalaTestCase {
  @Test
  def testCase() = {
    val zscript =
      """
			<window>
				<zscript>
					if (null == Sessions.getCurrent().getAttribute("MyDesktopCleanup"))
	Sessions.getCurrent().setAttribute("MyDesktopCleanup", new Integer(1));
				</zscript>
				Please press F5 5 times to reload this page, then you should see the Counts is greater than 1. (not for Opera)
				<separator/>
				Counts:<label id="msg" value="${sessionScope.MyDesktopCleanup}"/>
			</window>
		"""
    runZTL(zscript, () => {
      for (i <- 0 to 5)
        refresh();

      runRawZscript(zscript.toString())

      waitResponse()
      verifyTrue("The rmDesktop count should be greater than 1", 1 < parseInt(jq("$msg").text()));
    })
  }
}

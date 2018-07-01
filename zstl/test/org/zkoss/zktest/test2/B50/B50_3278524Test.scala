/* B50_3278524Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 18:47:36 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 3278524
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3278524.zul,B,E,Include")
class B50_3278524Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<tabbox>
				<tabs>
				<tab label="Hi"/>
				</tabs>
				<tabpanels>
				<tabpanel>
				You shall see a log (at the right bottom) showing "false"
			<include src="/test2/B50-3278524-inc.html"/>
				</tabpanel>
				</tabpanels>
			</tabbox>

    """
    runZTL(zscript,
      () => {
        waitResponse();
        verifyContains("Should appear a log message 'false'",
          jq("#zk_log").get(0).get("value"), "false")
      }
    );

  }
}
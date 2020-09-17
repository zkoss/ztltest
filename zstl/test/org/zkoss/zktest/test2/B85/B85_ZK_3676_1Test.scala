/* B85_ZK_3676Test.scala

	Purpose:

	Description:

	History:
		Wed, Nov 1, 2017 12:33:17 PM, Created by bobpeng

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3676_1Test extends ZTL4ScalaTestCase {
  @Test
  def test2() = {
    val zscript = """
     <include src="/test2/B85-ZK-3676.zul"/>
    """
    runZTL(zscript, () => {
      sleep(1000)
      click(jq("$red"))
      waitResponse();
      verifyFalse("Notification should be closed.", jq(".z-notification").isVisible());
    })
  }
}

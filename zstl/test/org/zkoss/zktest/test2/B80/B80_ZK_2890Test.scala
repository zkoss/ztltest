/* B80_ZK_2890Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016 11:30:17 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{SeleniumOnly, Tags};

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_2890Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val treerow = jq(".z-treerow").eq(0)
      dragAndDrop(treerow, "100,10")
      waitResponse()
      verifyContains(getZKLog(), ">>>3")
      verifyContains(getZKLog(), "true")
    })
  }
}

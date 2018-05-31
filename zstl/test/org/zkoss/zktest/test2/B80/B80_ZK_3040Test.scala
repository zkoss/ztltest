/* B80_ZK_3040Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016 11:15:53 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3040Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val icon = jq("div.z-icon-code").eq(0)
      verifyTrue(icon.exists())
      mouseDown(icon)
      verifyTrue(icon.hasClass("z-icon-code"))
    })
  }
}

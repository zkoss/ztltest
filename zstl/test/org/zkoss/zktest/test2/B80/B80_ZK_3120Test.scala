/* B80_ZK_3120Test.scala

	Purpose:

	Description:

	History:
		Wed, Jun  8, 2016 12:39:56 PM, Created by Sefi

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
class B80_ZK_3120Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val textbox = jq("@textbox")
      blur(textbox)
      sleep(1000)

      //original widget will lost after switched to compatible mode in ie8
      verifyTrue(textbox.exists())
    })
  }
}

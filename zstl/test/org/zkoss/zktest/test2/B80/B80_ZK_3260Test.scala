/* B80_ZK_3260Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016  9:44:43 AM, Created by Sefi

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
class B80_ZK_3260Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-datebox-button"))
      waitResponse()
      val cell = jq(".z-calendar-cell:eq(0)")
      click(cell)
      waitResponse()
      verifyNotEquals("", jq(".z-datebox-input").`val`())
    })
  }
}

/* B80_ZK_3333Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 12:20:49 PM, Created by Sefi

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
class B80_ZK_3333Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val tb = jq(".z-tbeditor-editor")
      click(tb)
      `type`(tb, "ss")
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("@label:eq(1)").text().trim().endsWith("PROXY MSG : original messagess"))
      verifyEquals("original messagess", jq("@label:eq(2)").text())
    })
  }
}

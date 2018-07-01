/* B80_ZK_3257Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 10:03:00 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3257Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val m1 = jq("@menu:eq(0)")
      val m2 = jq("@menu:eq(1)")
      val m1l = m1.offsetLeft()
      val m2l = m2.offsetLeft()
      click(m1)
      waitResponse()
      verifyEquals(m1l, m1.offsetLeft())
      verifyNotEquals("fixed", m1.css("position"))
      verifyEquals(m2l, m2.offsetLeft())
      verifyNotEquals("fixed", m2.css("position"))
    })
  }
}

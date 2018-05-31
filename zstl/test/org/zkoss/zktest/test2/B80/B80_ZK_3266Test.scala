/* B80_ZK_3266Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 11:23:15 AM, Created by Sefi

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
class B80_ZK_3266Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var gd = jq("@grid")
      var lt = jq("@listbox")
      val gdw = gd.width()
      val gdh = gd.height()
      val ltw = lt.width()
      val lth = lt.height()
      verifyEquals(gdw + 2, gd.parent().width())
      verifyEquals(gdh + 2, gd.parent().height())
      verifyEquals(ltw + 2, lt.parent().width())
      verifyEquals(lth + 2, lt.parent().height())
      click(jq("@button"))
      waitResponse()
      gd = jq("@grid")
      lt = jq("@listbox")
      verifyEquals(gdw, gd.width())
      verifyEquals(gdh, gd.height())
      verifyEquals(ltw, lt.width())
      verifyEquals(lth, lt.height())
    })
  }
}

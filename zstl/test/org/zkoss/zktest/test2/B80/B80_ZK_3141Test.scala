/* B80_ZK_3141Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 11:52:08 AM, Created by Sefi

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
class B80_ZK_3141Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val t = jq("@textbox")
      focus(t)
      blur(t)
      waitResponse()
      verifyTrue(jq(".z-errorbox:visible").length() > 0)
      chkpos

      click(jq("@button:eq(0)"))
      waitResponse()
      chkpos

      click(jq("@button:eq(1)"))
      waitResponse()
      chkpos

      click(jq("@button:eq(2)"))
      waitResponse()
      chkpos

      click(jq("@button:eq(0)"))
      waitResponse()

      val hd = jq(".z-window-header")
      dragdropTo(hd, "10,10", "30,30")
      waitResponse()
      chkpos
    })
  }

  def chkpos() = {
    val t = jq("@textbox")
    val pointer = jq(".z-errorbox-pointer:visible")

    val tbMidX = t.offsetLeft() + (t.outerWidth() / 2)
    val ptrMidX = pointer.offsetLeft() + (pointer.outerWidth() / 2)
    val tbWidthTol = (t.outerWidth() / 2) + 5

    val tbMidY = t.offsetTop() + (t.outerHeight() / 2)
    val ptrMidY = pointer.offsetTop() + (pointer.outerHeight() / 2)
    val tbHeightTol = (t.outerHeight() / 2) + 5

    verifyTolerant(tbMidY, ptrMidY, tbHeightTol)
    verifyTolerant(tbMidX, ptrMidX, tbWidthTol)
  }
}
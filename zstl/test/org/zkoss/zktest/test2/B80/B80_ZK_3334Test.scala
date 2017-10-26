/* B80_ZK_3334Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 12:33:17 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags, ZK};

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3334Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-bandbox-button"))
      waitResponse()
      verifyPopup(jq("@bandbox"), jq(".z-bandbox-popup"))

      click(jq(".z-combobox-button"))
      waitResponse()
      verifyPopup(jq("@combobox"), jq(".z-combobox-popup"))

      click(jq(".z-chosenbox-input"))
      waitResponse()
      verifyPopup(jq("@chosenbox"), jq(".z-chosenbox-popup"))
      click(jq("body"))
      waitResponse()

      click(jq(".z-datebox-button"))
      waitResponse()
      verifyPopup(jq("@datebox"), jq(".z-datebox-popup"))

      click(jq(".z-menu"))
      waitResponse()
      verifyPopup(jq("@menu"), jq(".z-menupopup"))

      val com = jq("@textbox")
      focus(com)
      blur(com)
      waitResponse()
      val pp = jq(".z-errorbox")
      val window = driver.manage().window()
      val size = window.getSize()
      if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
        verifyTolerant(com.offsetLeft() + com.outerWidth(), pp.offsetLeft(), 1)
      } else {
        verifyEquals(com.offsetLeft() + com.outerWidth(), pp.offsetLeft())
      }
      window.setSize(new Dimension(size.width - 100, size.height))
      waitResponse()
      if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
        verifyTolerant(com.offsetLeft() + com.outerWidth(), pp.offsetLeft(), 1)
      } else {
        verifyEquals(com.offsetLeft() + com.outerWidth(), pp.offsetLeft())
      }
    })
  }

  def verifyPopup(com: JQuery, pp: JQuery) = {
    val window = driver.manage().window()
    val size = window.getSize()
    if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
      verifyTolerant(com.offsetLeft(), pp.offsetLeft(), 1)
    } else {
      verifyEquals(com.offsetLeft(), pp.offsetLeft())
    }
    window.setSize(new Dimension(size.width - 100, size.height))
    waitResponse()
    if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
      verifyTolerant(com.offsetLeft(), pp.offsetLeft(), 1)
    } else {
      verifyEquals(com.offsetLeft(), pp.offsetLeft())
    }
    window.setSize(size)
    waitResponse()
  }
}

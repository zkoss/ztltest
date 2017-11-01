/* B85_ZK_3664Test.scala

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
import org.zkoss.ztl.Tags;

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3664Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var body = jq("body");
      var comboBtns = jq(".z-combobox-button");

      click(comboBtns.get(0))
      waitResponse()
      var width1 = jq(".z-combobox-popup.z-combobox-open:eq(0)").width()
      click(body)
      waitResponse()

      click(comboBtns.get(1))
      waitResponse()
      var width2 = jq(".z-combobox-popup.z-combobox-open:eq(0)").width()
      click(body)
      waitResponse()

      click(comboBtns.get(2))
      waitResponse()
      var width3 = jq(".z-combobox-popup.z-combobox-open:eq(0)").width()
      click(body)
      waitResponse()

      print("widths of popups: ")
      println(width1, width2, width3)
      verifyEquals("Width should be the same.", width1, width2)
      verifyEquals("Width should be the same.", width1, width3)
    })
  }
}

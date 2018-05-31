/* B80_ZK_3048Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016 12:14:34 PM, Created by Sefi

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
class B80_ZK_3048Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val listbox = jq(".z-listbox-body")
      listbox.get(0).set("scrollTop", 1000)
      waitResponse()
      var listitem = listbox.eq(0).find(".z-listitem").last()
      verifyTolerant(listitem.positionTop() + listitem.outerHeight(), listbox.get(0).get("clientHeight").toInt, 1)


      listbox.get(1).set("scrollLeft", 1000)
      waitResponse()
      listitem = listbox.eq(1).find(".z-listitem").first()
      verifyTolerant(listitem.positionLeft() + listitem.outerWidth(), listbox.get(1).get("clientWidth").toInt, 1)

      listbox.get(2).set("scrollTop", 1000)
      listbox.get(2).set("scrollLeft", 1000)
      waitResponse()
      listitem = listbox.eq(2).find(".z-listitem").last()
      verifyTolerant(listitem.positionTop() + listitem.outerHeight(), listbox.get(2).get("clientHeight").toInt, 1)
      verifyTolerant(listitem.positionLeft() + listitem.outerWidth(), listbox.get(2).get("clientWidth").toInt, 1)
    })
  }
}

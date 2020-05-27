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
import org.zkoss.ztl.annotation.Tags;

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
      verifyTolerant(listitem.offsetTop() + listitem.outerHeight(), listbox.eq(0).offsetTop() + listbox.eq(0).outerHeight(), 1)


      listbox.get(1).set("scrollLeft", 1000)
      waitResponse()
      listitem = listbox.eq(1).find(".z-listitem").first()
      verifyTolerant(listitem.offsetLeft() + listitem.outerWidth(), listbox.eq(1).offsetLeft() + listbox.eq(1).outerWidth(), 1)

      listbox.get(2).set("scrollTop", 1000)
      listbox.get(2).set("scrollLeft", 1000)
      waitResponse()
      listitem = listbox.eq(2).find(".z-listitem").last()
      verifyTolerant(listitem.offsetTop() + listitem.outerHeight(), listbox.eq(2).offsetTop() + listbox.eq(2).outerHeight(), 1)
      verifyTolerant(listitem.offsetLeft() + listitem.outerWidth(), listbox.eq(2).offsetLeft() + listbox.eq(2).outerWidth(), 1)
    })
  }
}

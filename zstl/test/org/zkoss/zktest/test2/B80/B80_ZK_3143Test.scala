/* B80_ZK_3143Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016  4:31:50 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import java.util

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.{ClientWidget, JQuery};

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3143Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val elements: JQuery = jq(".z-listitem-checkbox")
      var items: util.List[ClientWidget] = new util.ArrayList[ClientWidget]()
      items.add(elements.get(0))
      items.add(elements.get(5))
      shiftClickItems(items)
      verifyEquals("", getEval("(zk.ie && zk.ie == 8) ? document.selection.createRange().text : window.getSelection().toString()"))
    })
  }
}

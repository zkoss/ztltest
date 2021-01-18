/* B50_ZK_528Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 26 15:49:58 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  *
  * @author jumperchen
  */
@Tags(tags = "B50-ZK-528.zul,A,E,Grid,Listbox,EmptyMessage")
class B50_ZK_528Test extends ZTL4ScalaTestCase {

  @Test
  def testGridCase() = {
    runZTL(() => {

      val emp = jq("@grid").toWidget().$n("empty")
      val hiddenCol = jq("@grid").find("col[id*=hdfaker][style*=collapse]")
      val column = jq("@grid").find(".z-column")
      verifyEquals(column.length() - hiddenCol.length(), 1);
      verifyNotContains(hiddenCol.attr("id"), jq(".z-column").attr("id"))
      verifyTrue(jq(emp).isVisible());
      verifyEquals("Empty Message", jq(jq("@grid").toWidget().$n("empty")).text());

      click(jq("@button:eq(0)"));
      waitResponse();
      verifyFalse(jq(emp).isVisible());

      click(jq("@button:eq(1)"));
      waitResponse();
      verifyTrue(jq(emp).isVisible());

      click(jq("@button:eq(2)"));
      waitResponse();
      click(jq("@button:eq(2)"));
      waitResponse();
      verifyEquals(column.length() - hiddenCol.length(), 3);
      verifyTrue(jq(emp).isVisible());

      click(jq("@button:eq(3)"));
      waitResponse();
      verifyTrue((column.length() - hiddenCol.length()) == 0);
      verifyTrue(jq(emp).isVisible());
    })
  }
}

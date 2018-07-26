/* B50_3161535Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 10:49:33 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug 3161535
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3161535.zul,A,E,Grid,Column")
class B50_3161535Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(
      () => {
        var c1: Widget = engine.$f("c1")
        var l1: Widget = engine.$f("l1")
        var l2: Widget = engine.$f("l2")
        var l3: Widget = engine.$f("l3")
        var width = jq(c1.$n()).outerWidth();
        verifyTrue("first column shall align left, \noffsetLeft of first label= " +
          parseInt(l1.$n().attr("offsetLeft")) + " should smaller then 10",
          parseInt(l1.$n().attr("offsetLeft")) <= 20);
        verifyTrue("second column shall align center,\n offsetLeft of second label= " +
          parseInt(l2.$n().attr("offsetLeft")) + " should larger then width/3 (" + (width / 3) + ") and\n smaller then (width/3)*2 (" + (width / 3 * 2) + ")",
          parseInt(l2.$n().attr("offsetLeft")) >= (width / 3) && parseInt(l2.$n().attr("offsetLeft")) <= (width / 3 * 2));
        verifyTrue("The third column shall align right,\n offsetLeft of third label= " +
          parseInt(l3.$n().attr("offsetLeft")) + " should larger then width - 30 (" + (width - 30) + ")",
          parseInt(l3.$n().attr("offsetLeft")) >= width - 30);
      }
    );

  }
}
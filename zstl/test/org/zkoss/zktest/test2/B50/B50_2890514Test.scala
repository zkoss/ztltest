/* B50_2890514Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 12:59:15 CST 2011 , Created by benbai
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
  * A test class for bug 2890514
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2890514.zul,B,E,Grid,Row,Align")
class B50_2890514Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      var row1: Widget = engine.$f("row1");
      var fl: Widget = engine.$f("fl");
      var cel = jq(row1.$n()).find(".z-row-content").eq(0);
      var width = jq(row1.$n()).find(".z-row-inner").eq(0).innerWidth() - parseInt(cel.css("padding-right")) - parseInt(cel.css("padding-left"))
      var flOffsetLeft: Int = parseInt(fl.$n().attr("offsetLeft"));
      var flWd: Int = jq(fl.$n()).outerWidth();
      waitResponse();
      verifyTrue("the offsetLeft of File label should close to the right side of row1", flOffsetLeft > (width - flWd));
    }
    );
  }
}
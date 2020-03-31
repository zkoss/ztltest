/* B50_3303725Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 16:42:18 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3303725
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3303725.zul,A,E,Panel,Portallayout")
class B50_3303725Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        var ptl: Widget = engine.$f("ptl")
        var p1: Widget = engine.$f("p1")
        var p2: Widget = engine.$f("p2")
        var p3: Widget = engine.$f("p3")
        dragdropToObject(p2.$n("cap"), jq(p1.$n()).find(".z-panelchildren").get(0), "100,10", "100,180");
        waitResponse()
        var h1: Int = jq(jq(".z-portalchildren").toWidget().$n("cave")).height();
        var h2: Int = jq(p1.$n()).outerHeight() +
          jq(p2.$n()).outerHeight() +
          jq(p3.$n()).outerHeight();
        verifyTrue("the sum of the height of the three panel (" + h2
          + ") should close to the height of the Portallayout (" + h1
          + ")", getEval("Math.abs(" + h1 + " - " + h2 + ") < 10"))
        verifyEquals(jq(ptl.$n()).find(".z-panel").get(1).attr("id"), p2.$n().attr("id"));
      }
    );

  }
}
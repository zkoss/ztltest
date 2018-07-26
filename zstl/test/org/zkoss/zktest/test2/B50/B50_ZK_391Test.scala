/* B50_ZK_391Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 19 15:34:50 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import java.lang._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-391
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-391.zul,A,E,Popup,onOpen")
class B50_ZK_391Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var lb1: Widget = engine.$f("lb1")
        var lb2: Widget = engine.$f("lb2")
        var lb3: Widget = engine.$f("lb3")
        var javaLbl: Widget = engine.$f("javaLbl")

        def checkPopup(lb: Widget, ppName: String) {
          mouseOver(lb);
          var pp: Widget = engine.$f(ppName);

          // wait at most 3 seconds
          sleep(3000)
          waitResponse()
          verifyTrue("popup should exist and visible", pp.exists())
          verifyEquals("visible", pp.$n().attr("style.visibility"))
          verifyNotContains("popup should exist and visible", pp.$n().attr("style.display"), "none")
          var ppRight: Int = jq(pp.$n()).offsetLeft() + jq(pp.$n()).outerWidth();
          var lbRight: Int = jq(lb.$n()).offsetLeft() + jq(lb.$n()).outerWidth();
          verifyTrue("the right side of popup should close to and slightly over the right side of label", getEval("Math.abs(" + ppRight + " - " + lbRight + ") <= 10"))
          mouseOver(jq("$l1"))
          waitResponse()
        }

        checkPopup(lb1, "zulPu1");
        checkPopup(lb2, "zulPu2");
        checkPopup(lb3, "zulPu3");
        checkPopup(javaLbl, "javaPu");
      }
    );

  }
}
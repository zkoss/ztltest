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

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

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
        var (lb1: Widget,
        lb2: Widget,
        lb3: Widget,
        javaLbl: Widget) = (
          engine.$f("lb1"),
          engine.$f("lb2"),
          engine.$f("lb3"),
          engine.$f("javaLbl")
        );
        def checkPopup(lb: Widget, ppName: String) {
          mouseOver(lb);
          var t1: Long = System.currentTimeMillis();
          var pp: Widget = engine.$f(ppName);

          // wait at most 3 seconds
          while (!pp.exists() && System.currentTimeMillis() - t1 <= 3000) {
            sleep(300);
          }
          waitResponse()
          verifyTrue("popup should exist and visible", pp.exists() && "visible".equals(pp.$n().get("style.visibility")) &&
            !pp.$n().get("style.display").contains("none"));
          var ppRight: Int = jq(pp.$n()).offsetLeft() + jq(pp.$n()).outerWidth();
          var lbRight: Int = jq(lb.$n()).offsetLeft() + jq(lb.$n()).outerWidth();
          verifyTrue("the right side of popup should close to and slightly over the right side of label", Math.abs(ppRight - lbRight) <= 10);
          mouseOut(lb);
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
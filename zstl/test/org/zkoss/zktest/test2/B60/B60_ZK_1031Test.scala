/* B60_ZK_1031Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 12:01:41 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-1031
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-1031.zul,B,E,ListModel")
class B60_ZK_1031Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        var sbx: Widget = engine.$f("sbx");

        select(sbx, 1);
        waitResponse();
        verifyFalse("No exception",
          jq(".z-window-modal").exists());
        click(jq("@button"));
        waitResponse();
        for (i <- 1 to 5) {
          verifyEquals("Select index in label " + i + " should be 1",
            engine.$f("lb" + i).$n().attr("innerHTML"), "1")
        }
      }
    );
  }
}
/* B50_ZK_409Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 19 11:05:38 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.{JQuery, Widget}

/**
  * A test class for bug ZK-409
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-409.zul,A,E,IdSpace")
class B50_ZK_409Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var btn: Widget = engine.$f("btn");

        click(btn);
        waitResponse();
        click(jq(".z-window-highlighted").toWidget().$n("close"));
        waitResponse();
        click(btn);
        waitResponse();

        // for exception alert
        verifyFalse("should not have modal window for exception",
          jq(".z-window-modal").exists())
        // for js error
        verifyFalse("should not have any js error",
          jq(".z-error").exists());
        var hlWins: JQuery = jq(".z-window-highlighted");
        verifyTrue("only one highlighted window and contains expected message",
          (hlWins.length() == 1))
        verifyContains(jq(".z-messagebox-window").find(".z-label")
          .text(), "Question is pressed. Are you sure?")
      }
    );

  }
}
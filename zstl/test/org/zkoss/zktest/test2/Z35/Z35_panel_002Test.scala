/* Z35_panel_002Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 16:58:43 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug panel-002
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z35-panel-002.zul,Z35,A,E,Panel")
class Z35_panel_002Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        def clickThenValidate(selector: String, validator: () => Unit) {
          clickAt(jq(selector), "2,2");
          waitResponse(true);
          validator();
        }

        clickThenValidate("$btn1", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible())
        });
        clickThenValidate("$btn2", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("min")).isVisible());
        });
        clickThenValidate("$btn3", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("min")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("max")).isVisible());
        });
        clickThenValidate("$btn4", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("min")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("max")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("close")).isVisible());
        });

        clickThenValidate("$btn3", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("min")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("close")).isVisible());
        });
        clickThenValidate("$btn3", () => {
          verifyTrue(jq(jq("@panel").toWidget().$n("exp")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("min")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("max")).isVisible());
          verifyTrue(jq(jq("@panel").toWidget().$n("close")).isVisible());
        });

        clickThenValidate("$btnFloat", () => {
          verifyEquals(jq(".z-panel").css("position"), "absolute");
        });

        verifyTrue(jq(".z-panel-header-move").length() == 0);


        clickThenValidate("$btnMove", () => {
          verifyTrue(jq(".z-panel-header-move").length() == 1);
        });

        clickThenValidate("$btnFloat", () => {
          verifyNotEquals(jq(".z-panel").css("position"), "absolute");
          //We can't move it when it's not in floatable mode.
          verifyTrue(jq(".z-panel-header-move").length() == 0);
        });


        clickAt(jq(jq("@panel").toWidget().$n("exp")), "2,2");
        waitResponse(true);
        sleep(200);
        verifyFalse(jq(".z-panel-body").isVisible());

        clickAt(jq(jq("@panel").toWidget().$n("exp")), "2,2");
        waitResponse(true);
        sleep(200);
        verifyTrue(jq(".z-panel-body").isVisible());

      }
    );
  }
}
/* Z35_panel_001Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 12:42:36 CST 2011 , Created by TonyQ
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
  * A test class for bug panel-001
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z35-panel-001.zul,Z35,A,E,Panel")
class Z35_panel_001Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        verifyEquals(jq(".z-panel-header").length, 0);
        click(jq("$btn1"));
        waitResponse();

        verifyEquals(jq(".z-panel-header").length, 1);
        verifyEquals(jq(".z-panel-header").text(), "Panel Component");


        verifyEquals(jq(".z-panelchildren").length, 1);
        click(jq("$btn2"));
        waitResponse();
        verifyFalse(jq(".z-panel").hasClass(".z-panel-noborder"));

        val w = jq(".z-panel").outerWidth()
        click(jq("$btn4"));
        waitResponse();
        verifyNotEquals(w, jq(".z-panel").outerWidth())
      }
    )
  }
}
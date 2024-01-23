/* B35_2075761Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 24, 2011 09:30:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2075761.zul,B,E,Window,Button")
class B35_2075761Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      // Verify that the west splitter is not visible
      verifyFalse("The west splitter should not be visible", jq(jq(".z-west").toWidget().$n("split")).isVisible());

      // Record the width of the center zone to verify sizing
      val noSplitterWidth: Int = jq(".z-center").width();
      //      This doesn't work
      //      val noSplitterWidth: Int = jq(engine.$f("c")).width();

      // Click the button to change the splitter
      click(jq("@button"));
      waitResponse();

      // Record the width of the center zone to verify sizing
      val withSplitterWidth: Int = jq(".z-center").width();

      // Verify that the west splitter is visible
      verifyTrue("The west splitter should be visible", jq(jq(".z-west").toWidget().$n("split")).isVisible());

      // Verify the sizing of the center zone. It should be thinner than previously
      verifyTrue("The width of the center zone should be smaller than without the splitter", (noSplitterWidth - withSplitterWidth) == 8);

      // Click again the button to change the splitter
      click(jq("@button"));
      waitResponse();

      // Verify that the west splitter is not visible
      verifyFalse("The west splitter should not be visible", jq(jq(".z-west").toWidget().$n("split")).isVisible());

    })
  }
}
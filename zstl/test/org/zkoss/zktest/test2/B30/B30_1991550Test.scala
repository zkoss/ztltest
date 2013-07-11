/* B30_1991550Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 15, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Element
import org.junit.Test

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1991550.zul,B,E,Window,Button")
class B30_1991550Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript = """
      <groupbox id="gb" mold="3d" width="300px">
        <caption image="/test2/img/inet.png" label="fruits">
          <toolbarbutton label="action" image="/test2/img/inet.png">
          </toolbarbutton>
        </caption>
        When you click the right image, this groupbox cannot be collapsed, but the left image can.
      </groupbox>
    """;
    runZTL(zscript, () => {

      // Click on the first image to collapse the groupbox
      click(jq(".z-caption").toWidget().$n("cave"));
      waitResponse(true);

      // The label in the groupbox must be invisible
      verifyFalse(jq(".z-label").isVisible());

      // Click on the first image to bring back the groupbox
      click(jq(".z-caption").toWidget().$n("cave"));
      waitResponse(true);

      // Click on the second image (toolbarbutton)
      click(jq(".z-toolbarbutton"));
      waitResponse(true);

      // The label in the groupbox must be visible (not collapsed)
      verifyTrue(jq(".z-label").isVisible());

    })
  }
}
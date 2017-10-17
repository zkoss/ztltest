/* B35_2614901Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 15, 2012 10:30:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys

/**
 * @author Fernando Selvatici
 *
 */
class B35_2614901Test extends ZTL4ScalaTestCase {
  def testClick() = {
runZTL(() => {
      // Click on Project menu
      click(jq(".z-menu").get(0));
      waitResponse();
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);

      waitResponse();

      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);
      waitResponse();

      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);
      waitResponse();

      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.UP);
      waitResponse();

      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.UP);
      waitResponse();

      // Verify the correct selected item
      verifyTrue("The selected item should be 'New'",(jq(".z-menuitem-hover").text().contains("New")));

    })
  }
}
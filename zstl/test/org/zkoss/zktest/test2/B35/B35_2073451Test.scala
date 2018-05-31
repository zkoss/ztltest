/* B35_2073451Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 7, 2011 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2073451.zul,B,E,Window,Button")
class B35_2073451Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {

      if (!isIE && !isEdge) {
        click(jq("$anc"));
        // Press the TAB key
        // Note: Does not work on Chrome due to a ChromeDriver issue: http://code.google.com/p/selenium/issues/detail?id=2328
        sendKeys(jq("$anc"), Keys.TAB);
        waitResponse();
      } else { // ie cant focus correct
        click(jq("$FocusOnMe"));
        waitResponse();
      }
      // Fails with sendKeys. I works clicking on the button
      // click(jq(".z-button:contains(FocusOnMe)"));

      // Verify that the label of the button is correct
      verifyTrue("The button label must be 'Focused OK'", jq(".z-button:contains(Focused OK)").exists());

      // Press the TAB key on first button
      // This doesn't work: sendKeys(jq(".z-button:contains(FocusOnMe)"), Keys.TAB);
      sendKeys(jq("$FocusOnMe"), Keys.TAB);
      waitResponse();

      // Press the TAB key on second button
      // This doesn't work: sendKeys(jq(".z-button:contains(BlurMe)"), Keys.TAB);
      sendKeys(jq("$BlurMe"), Keys.TAB);
      waitResponse();

      // Verify that the label of the second button is correct
      verifyTrue("The button label must be 'Blurred OK'", jq(".z-button:contains(Blurred OK)").exists());

      // Click on third button
      click(jq(".z-button:contains(google)"));

      waitForPageToLoad("2000")
      // Verify that the google page is opened by verifying the existence of the "Search" button
      verifyTrue("The visible page should be www.google.com", getEval("location.href").contains("google"));


    })
  }
}
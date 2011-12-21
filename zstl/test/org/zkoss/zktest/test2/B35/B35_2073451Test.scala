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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2073451.zul,B,E,Window,Button")
class B35_2073451Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul/zul.xsd">
        <window title="Test button reference to processes" border="normal" width="400px">
          <groupbox>
            <vbox>
              <label value="1.press TAB to focus on the first button, the text on button should change."/>
              <label value="2.press TAB to focus away on the second button, the text on button should change."/>
              <label value="3.click on third button should lead to a new page in google."/>
            </vbox>
          </groupbox>
          <vbox>
            <hbox>
              <button id="FocusOnMe" label="FocusOnMe" onFocus='self.setLabel("Focused OK")' tabindex="1"/>
              Focus gained Test
            </hbox>
            <hbox>
              <button id="BlurMe" label="BlurMe" onBlur='self.setLabel("Blurred OK")' tabindex="2"/>
              Focus lost Test
            </hbox>
            <hbox>
              <button label="http://www.google.com" href="http://www.google.com"/>
              Hyperlink Test
            </hbox>
          </vbox>
        </window>
      </zk>
    }
    runZTL(zscript, () => {

      click(jq(".z-label:contains(1.press)"));

      // Press the TAB key
      // Note: Does not work on Chrome due to a ChromeDriver issue: http://code.google.com/p/selenium/issues/detail?id=2328
      sendKeys(jq(".z-label:contains(1.press)"), Keys.TAB);
      waitResponse();
      // Fails with sendKeys. I works clicking on the button
      // click(jq(".z-button:contains(FocusOnMe)"));

      // Verify that the label of the button is correct
      verifyTrue("The button label must be 'Focused OK'", jq(".z-button-cm:contains(Focused OK)").exists());

      // Press the TAB key on first button
      // This doesn't work: sendKeys(jq(".z-button:contains(FocusOnMe)"), Keys.TAB);
      sendKeys(engine.$f("FocusOnMe").$n("btn"), Keys.TAB);
      waitResponse();

      // Press the TAB key on second button
      // This doesn't work: sendKeys(jq(".z-button:contains(BlurMe)"), Keys.TAB);
      sendKeys(engine.$f("BlurMe").$n("btn"), Keys.TAB);
      waitResponse();

      // Verify that the label of the second button is correct
      verifyTrue("The button label must be 'Blurred OK'", jq(".z-button-cm:contains(Blurred OK)").exists());

      // Click on third button
      click(jq(".z-button:contains(www.google.com)"));
      waitResponse();

      // Verify that the google page is opened by verifying the existence of the "Search" button
      verifyTrue("The visible page should be www.google.com", jq("input[name=btnK]").exists());

    })
  }
}
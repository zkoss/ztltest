/* B30_2080237Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.openqa.selenium.By

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2080237.zul,B,E,Window,Button")
class B30_2080237Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk>
        Please click the menuitem, and then nothing happens.(That is correct.)
        <menubar autodrop="true">
          <menuitem onClick='alert("This is error!");' label="Click Me..." href="http://www.zkoss.org" disabled="true"/>
        </menubar>
      </zk>
    }
    runZTL(zscript, () => {
      // Click the button
      click(jq("button"));

      // Verify that the zkoss page is opened by verifying the existence of the "Demo" button
      verifyFalse("The page www.zkoss.org should not be visible", getWebDriver().findElement(By.cssSelector(".button-demo")).isDisplayed());
    })
  }
}
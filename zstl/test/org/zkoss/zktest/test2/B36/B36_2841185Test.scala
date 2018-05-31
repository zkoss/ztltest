/* B36_2841185Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jun 11, 2012 11:30:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B36-2841185.zul,B,E,Window,Button")
class B36_2841185Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window height="400px">
        <zscript>
          String[] data = new String[100];
for(int i = 0; i&lt;data.length;i++)
data[i] = "data_"+i;
ListModel model = new ListModelList(data);
        </zscript>
        <caption label="Firefox Bug"/>
        <borderlayout>
          <north splittable="true" height="180px">
            <borderlayout>
              <north size="10px" border="0"></north>
              <center id="nc" flex="true" border="none" style="padding:5px">
                <grid mold="paging" model="&#36;{model}">
                  <columns>
                    <column label="Grid"/>
                  </columns>
                </grid>
              </center>
            </borderlayout>
          </north>
          <center flex="true" style="padding:5px">
            <div>
              Please insert 2 into the paging number, and press ENTER, if you see the grid disappears that is a bug.(Firefox only)
            </div>
          </center>
        </borderlayout>
      </window>
    """
    runZTL(zscript, () => {
      // Click paging field
      click(jq(".z-paging-input"));
      waitResponse();

      // Remove the value '1'
      sendKeys(jq(".z-paging-input").toElement(), Keys.BACK_SPACE);
      waitResponse();

      // Insert value '2'
      sendKeys(jq(".z-paging-input").toElement(), "2");
      waitResponse();

      // Press Enter key
      sendKeys(jq(".z-paging-input").toElement(), Keys.ENTER);
      waitResponse();

      // Verify that the grid exists
      verifyTrue("The grid should be visible", jq(".z-grid").isVisible());
    })
  }
}
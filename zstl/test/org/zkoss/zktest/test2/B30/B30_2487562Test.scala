/* B30_2487562Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 16, 2012 14:30:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2487562.zul,B,E,Window,Button")
class B30_2487562Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <window title="Listbox" border="normal">
        Please press HOME and END on the keyboard, you should see that the cursor in the input element works well. (Firefox 3 only)
        <listbox rows="2">
          <listitem>
            <listcell>
              <textbox value="Jerry" width="150px" focus="true"/>
            </listcell>
          </listitem>
          <listitem label="Inbox"/>
          <listitem label="Received"/>
          <listitem label="Draft"/>
        </listbox>
      </window>
    """
    runZTL(zscript, () => {
      var tb = jq("@textbox");
      var zk_tb = zk(tb);

      // Press the HOME key
      sendKeys(tb, Keys.HOME);
      // The cursor must be in the first position
      verifyEquals(0, zk_tb.eval("getSelectionRange()[0]"));

      // Press the END key
      sendKeys(tb, Keys.END);
      // The cursor must be in the last position (Jerry length == 5)
      verifyEquals(5, zk_tb.eval("getSelectionRange()[0]"));

    })
  }
}
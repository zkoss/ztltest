/* B35_2280308Test.scala

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
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2280308.zul,B,E,Window,Button")
class B35_2280308Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
        <window title="Test Wrong Value Exception" border="normal" width="1200px" height="600px">
          <zscript>
            <![CDATA[

String[] data = new String[200];
for(int j=0; j < data.length; ++j) {
data[j] = "option "+j;
}
ListModel strset = new SimpleListModel(data);


void test() {
uiDecimalbox.focus();
uiDecimalbox.getValue();

}  ]]>
          </zscript>
          Please scroll down to press the submit button, than you should see the Warning box.
          <panel style="margin-left:10px" width="800px" height="500px" title="TEST PANEL" border="normal" visible="true">
            <panelchildren id="pc" style='background:white;background:white;overflow:auto;'>
              <decimalbox id="uiDecimalbox" constraint="no empty"/>
              <listbox id="list" model="${strset}" width="200px">
                <listhead>
                  <listheader label="TEST ITEMS" sort="auto"/>
                </listhead>
              </listbox>
              <button label="submit" onClick="test()"/>
            </panelchildren>
          </panel>
        </window>
      </zk>
    """
    runZTL(zscript, () => {
      var pc = engine.$f("pc").$n();

      // Scroll the panelchildren
      pc.eval("scrollTop = " + jq(pc).scrollHeight());
      waitResponse();

      // Click on submit button
      click(jq(".z-button"));
      waitResponse();

      verifyTrue("It should be visible an error box", jq(".z-errorbox").exists());
    })
  }
}
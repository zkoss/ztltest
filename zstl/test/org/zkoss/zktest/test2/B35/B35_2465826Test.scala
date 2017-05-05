/* B35_2465826Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 13, 2012 12:00:00 AM , Created by Fernando Selvatici
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
@Tags(tags = "B35-2465826.zul,B,E,Window,Button")
class B35_2465826Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = """
      <zk>
        1. Please click on one listitem, and press Enter on the keyboard.
        <separator/>
        2. After the dialog showed, please press Enter on the keyboard again.
        <separator/>
        3. Then, the focus should be on the listitem, you can try to press Up and Down key to test whether the selected item is work well or not.
        <zscript>
          Listitem listitem = new Listitem();
          <![CDATA[  
	String[] data = new String[30];
	int j=0;
	for(int j=0; j < data.length; ++j){
		data[j] = "option000000 "+j;
		j++;
	}
	ListModel strset = new SimpleListModel(data);
]]>
        </zscript>
        <window id="win" width="400px" border="normal">
          <attribute name="onOK">
            <![CDATA[  
            import org.zkoss.zk.ui.event.EventListener;

	Messagebox.show("123", "Prompt", Messagebox.OK, Messagebox.QUESTION, new EventListener(){
              public void onEvent(Event evt) {
                listitem.setFocus(true);
              }
            }
            );
]]>
          </attribute>
          <listbox id="list" width="200px" rows="10" model="${strset}">
            <attribute name="onSelect">
              listitem = list.getSelectedItem();
            </attribute>
            <listhead>
              <listheader id="lhd" label="Load on Demend" sort="auto"/>
            </listhead>
          </listbox>
        </window>
      </zk>
    """
runZTL(zscript, () => {
      // Click on second item
      click(jq("@listitem .z-listcell:eq(1)"));
      
      // Record the selected item text
      val itemText = jq(".z-listitem-selected").text();
      
      verifyFalse("The selection cannot be empty", itemText.isEmpty());
      
      // Press enter key
      sendKeys(jq("@listbox").toWidget().$n("a"), Keys.ENTER);
      
      waitResponse(true)
      // Verify that the messagebox is visible
      verifyTrue("The Messagebox should be visible", jq(".z-messagebox-window").exists());
      
      // Press enter key again
      sendKeys(jq("@button"), Keys.ENTER);
      
      // Verify that the selected item is the same as before
      verifyTrue("The selected item changed", itemText.equals(jq(".z-listitem-selected").text()));
    })
  }
}
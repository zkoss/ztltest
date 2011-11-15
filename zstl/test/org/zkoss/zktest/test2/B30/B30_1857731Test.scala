/* B30_1829397Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 12, 2011 19:29:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1829397.zul,B,E,Window,Button")
class B30_1857731Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window title="Listbox Bug">
        <toolbarbutton id="With Bug" label="Click Me! And no error msg!" onClick="openNewTab()"/>
        <tabbox>
          <tabs id="tbsMain">
            <tab label="tab1"/>
          </tabs>
          <tabpanels id="tbpMain">
            <tabpanel>
              <listbox width="250px">
                <listhead sizable="true">
                  <listheader label="name"/>
                  <listheader label="gender"/>
                </listhead>
                <listitem>
                  <listcell label="Mary"/>
                  <listcell label="FEMALE"/>
                </listitem>
                <listitem>
                  <listcell label="John"/>
                  <listcell label="MALE"/>
                </listitem>
                <listitem>
                  <listcell label="Jane"/>
                  <listcell label="FEMALE"/>
                </listitem>
                <listitem>
                  <listcell label="Henry"/>
                  <listcell label="MALE"/>
                </listitem>
              </listbox>
            </tabpanel>
          </tabpanels>
        </tabbox>
        <zscript><![CDATA[
	public void openNewTab()
	{
		Tabpanel tabPanel = new Tabpanel();
		tbpMain.appendChild(tabPanel);
		
		Tab tab = new Tab();
		tab.setLabel("Tab2");
		tbsMain.appendChild(tab);
		
		tabPanel.appendChild(new Label("Test"));
		
		tab.setSelected(true);
	}
	]]></zscript>
      </window>
    }
    runZTL(zscript, () => {
      // Click on the toolbarbutton
      click(jq(".z-toolbarbutton"));
      waitResponse();

      // Verify there is no javascript error
      verifyFalse(jq(".z-error").exists());
      
      // Verify that the label in the tab exists
      verifyTrue(jq(".z-label:contains(Test)").get(0).exists());

    })
  }
}
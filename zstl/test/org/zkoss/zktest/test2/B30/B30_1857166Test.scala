/* B30_1857166Test.scala

{{IS_NOTE
    Purpose:
        
    Description:
        
    History:
        Tue Nov 08 22:51:02 GFT 2011, Created by ldnigro
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 1857166
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1857166.zul,A,E,Listbox")
class B30_1857166Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
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
                Listbox lb = new Listbox();
                new Listitem("test").setParent(lb);
                tabPanel.appendChild(lb);
        
                tab.setSelected(true);
            }
            ]]></zscript>
        </window>
    """
    runZTL(zscript,
      () => {

        //Click button
        click(jq("@toolbarbutton"));
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-msgbox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Tab2 must be added
        verifyTrue(jq("@tab:eq(1)").exists());

        //Verify Listbox is added
        verifyTrue(jq("@tabpanel:eq(1) @listbox").isVisible());

        click(jq("@toolbarbutton"));
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-msgbox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Tab3 must be added
        verifyTrue(jq("@tab:eq(2)").exists());

        //Verify Listbox is added
        verifyTrue(jq("@tabpanel:eq(2) @listbox").isVisible());

      }
    );
  }
}

/* B35_2075714Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 15, 2011 00:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.JQuery

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2075714.zul,B,E,Window,Button")
class B35_2075714Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul/zul.xsd">
        Tabbox accordion-lite Test
        <groupbox>
          <vbox>
            1.You shouldn't see an error saying  js/zul/tabs.js not found
            <label value="2.Click upon the Tab2 and click upon the Tab1, the tab width in tab1 shouldn't change."/>
          </vbox>
        </groupbox>
        <window title="Test Tabbox accordion-lite" border="normal" width="100%">
          <tabbox width="400px" mold="accordion-lite">
            <tabs>
              <tab label="Tab 1" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
              <tab label="Tab 2" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
              <tab label="Tab 3" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
              <tab label="Tab 4" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
              <tab label="Tab 5" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
              <tab label="Tab 6" image="/test2/img/folder.gif" closable="true" draggable="true" droppable="true" focus="true" tooltiptext="Test ToolTip" width="100%"/>
            </tabs>
            <tabpanels>
              <tabpanel>
                <tabbox orient="vertical">
                  <tabs width="20px">
                    <tab label="A"/>
                    <tab label="B"/>
                    <tab label="C"/>
                    <tab label="D"/>
                    <tab label="E"/>
                  </tabs>
                  <tabpanels>
                    <tabpanel>This is panel A</tabpanel>
                    <tabpanel>This is panel B</tabpanel>
                    <tabpanel>This is panel C</tabpanel>
                    <tabpanel>This is panel D</tabpanel>
                    <tabpanel>This is panel E</tabpanel>
                  </tabpanels>
                </tabbox>
              </tabpanel>
              <tabpanel>
                This is panel 2
The second panel
              </tabpanel>
              <tabpanel>
                <hbox spacing="0">
                  <window border="normal">0</window>
                  <vbox spacing="0">
                    <hbox spacing="0">
                      <window border="normal">1</window>
                      <window border="normal">2</window>
                      <vbox spacing="0">
                        <window border="normal">3</window>
                        <window border="normal">4</window>
                      </vbox>
                    </hbox>
                    <hbox spacing="0">
                      <vbox spacing="0">
                        <window border="normal">5</window>
                        <window border="normal">6</window>
                      </vbox>
                      <window border="normal">7</window>
                      <window border="normal">8</window>
                      <window border="normal">9</window>
                    </hbox>
                  </vbox>
                </hbox>
                <hbox spacing="0" width="100%" height="200px">
                  <vbox spacing="0" width="100%" height="100%" heights="100px">
                    Column 1-1: The left-top box. To know whether a splitter
		is collapsed, you can listen to the onOpen event.
                    <splitter collapse="after"/>
                    Column 1-2: You can enforce to open or collapse programming
		by calling setOpen method.
                  </vbox>
                  <splitter collapse="before"/>
                  Column 2: Whether a splitter allows users to open or collapse
	depending on the collapse attribue.
                </hbox>
              </tabpanel>
              <tabpanel>
                <vbox>
                  Which kind of fruit do you want?
                  <groupbox id="gb" mold="3d" width="300px">
                    <caption image="/test2/img/inet.png" label="fruits"/>
                    <radiogroup onCheck="fruit.value = self.selectedItem.label">
                      <radio label="Apple"/>
                      <radio label="Orange"/>
                      <radio label="Grape"/>
                    </radiogroup>
                  </groupbox>
                  <hbox>
                    You have selected :<label id="fruit"/>
                  </hbox>
                  <checkbox label="Use 3d groupbox" checked="true" onCheck='gb.mold=self.checked? "3d": "default"'/>
                </vbox>
              </tabpanel>
              <tabpanel>
                <grid>
                  <columns sizable="true">
                    <column label="Type" sortAscending="&#36;{asc}" sortDescending="&#36;{dsc}"/>
                    <column label="Content"/>
                  </columns>
                  <rows>
                    <row>
                      <label value="File:"/>
                      <textbox width="98%"/>
                    </row>
                    <row>
                      <label value="Type:"/>
                      <hbox>
                        <listbox rows="1" mold="select">
                          <listitem label="Java Files,(*.java)"/>
                          <listitem label="All Files,(*.*)"/>
                        </listbox>
                        <button label="Browse..."/>
                      </hbox>
                    </row>
                    <row>
                      <label value="Options:"/>
                      <textbox rows="3" width="98%"/>
                    </row>
                  </rows>
                </grid>
              </tabpanel>
              <tabpanel>
                <vbox>
                  <radiogroup>
                    <radio label="Apple"/>
                    <radio label="Orange"/>
                    <radio label="Grape"/>
                  </radiogroup>
                  <separator bar="true"/>
                  <checkbox label="Apple"/>
                  <checkbox label="Orange"/>
                  <checkbox label="Grape"/>
                </vbox>
              </tabpanel>
            </tabpanels>
          </tabbox>
        </window>
      </zk>
    }
    runZTL(zscript, () => {
      // Verify that there is not an error message
      verifyFalse(jq(".z-error").exists());

      // Click on tab 2
      click(jq("@tab:contains(Tab 2)"));

      // Record tab 1 width
      val width_tab1_a = jq("@tab:contains(Tab 1)").width();

      // Click on tab 1
      click(jq("@tab:contains(Tab 1)"));

      // Record tab 1 width
      val width_tab1_b = jq("@tab:contains(Tab 1)").width();

      verifyTrue("The width of tab 1 should not vary after click on tabs", width_tab1_a == width_tab1_b);
    })
  }
}
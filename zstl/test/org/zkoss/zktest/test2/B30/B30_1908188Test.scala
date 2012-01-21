/* B30_1908188Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 23, 2011 10:00:00 PM , Created by Fernando Selvatici
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
import org.zkoss.ztl.ZK

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1908188.zul,B,E,Window,Button")
class B30_1908188Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window id="testWindow" border="normal" mode="modal" title="Test Window" width="600px" sizable="true" contentStyle="overflow:auto">
        <html><![CDATA[
<ol>
	<li>Click "Test" and then "Show popup below component..."<br/>
	You will see popup shown right below "Test"</li>
	<li>Click "Test" and then "Show popup at x,y position..."<br/>
	You will see popup shown at (x=50px, y=50px) according to browser's top-left corner.</li>
]]></html>
        <zscript>
          <![CDATA[
          public class PopupOpenEventListener implements EventListener{

            public PopupOpenEventListener (Popup resizePopup) {
              resizePopup.addEventListener(Events.ON_OPEN, this);
            }

            public void onEvent(Event event) {
              System.out.println("Event received: " + event.getName());
              if (event instanceof OpenEvent) {
                OpenEvent openEvent = (OpenEvent)event;
                if (openEvent.isOpen()) {
                }
              }
            }
          }
        ]]>
        </zscript>
        <popup id="ResizePopup" style="border: visible" width="300px">
          <vbox>
            <vbox spacing="1em">
              <label value="Resize Plot" style="font-weight: bold"/>
              <hbox align="center">
                <label value="Width"/>
                <doublebox id="plotWidthValue" value="100.0" width="30px"/>
                <listbox id="plotWidthType" rows="1" mold="select">
                  <listitem id="plotWidthPixels" label="Pixels" selected="true"/>
                  <listitem id="plotWidthPercent" label="Percent"/>
                </listbox>
              </hbox>
              <hbox align="center">
                <label value="Height"/>
                <doublebox id="plotHeightValue" value="100.0" width="30px"/>
                <listbox id="plotHeightType" rows="1" mold="select">
                  <listitem id="plotHeightPixels" label="Pixels" selected="true"/>
                  <listitem id="plotHeightPercent" label="Percent"/>
                </listbox>
              </hbox>
              <checkbox id="plotDefaultSize" label="Set to default size"/>
            </vbox>
            <separator bar="true"/>
            <hbox>
              <label value="    "/>
              <button label="OK"/>
              <button label="Cancel"/>
            </hbox>
          </vbox>
        </popup>
        <zscript>
          PopupOpenEventListener popupOpenEventListener = new PopupOpenEventListener(ResizePopup);
		String xpos = "50px";
		String ypos = "50px";
        </zscript>
        <menubar id="menubar">
          <menu id="testMenu" label="Test">
            <menupopup>
              <menuitem label="Show popup below component..." onClick="ResizePopup.open(testMenu)"/>
              <menuitem label="Show popup at x,y position..." onClick="ResizePopup.open(xpos, ypos)"/>
            </menupopup>
          </menu>
        </menubar>
      </window>
    }
    runZTL(zscript, () => {
      // Record Menu position
      var xMenu: Int = getElementPositionLeft(jq("$testMenu")).intValue();
      var yMenu: Int = getElementPositionTop(jq("$testMenu")).intValue();

      // Click on the menu
      click(jq("$testMenu"));

      waitResponse();
      
      // Click of first menu item
      click(jq(".z-menuitem").get(0));

      waitResponse();
       
      // Record Popup position
      var x: Int = getElementPositionLeft(jq(".z-popup")).intValue();
      var y: Int = getElementPositionTop(jq(".z-popup")).intValue();

      // Verify that the popup is below the test menu. It may fail if the browser is sized with a small height and width
      verifyTrue("The popup must be at right and below of the menu", x > xMenu && y > yMenu);

      // Click on the menu
      click(jq("$testMenu"));

      waitResponse();
      
      // Click of second menu item
      click(jq(".z-menuitem").get(1));

      waitResponse();
      // Record Popup position
      x = getElementPositionLeft(jq(".z-popup")).intValue();
      y = getElementPositionTop(jq(".z-popup")).intValue();

      // Verify that the popup is in position (50,50). 
      verifyTrue("The popup must be at position (50,50)", x == 50 && y == 50);

    })
  }
}
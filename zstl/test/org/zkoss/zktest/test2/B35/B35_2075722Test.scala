/* B35_2075722Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.Element

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2075722.zul,B,E,Window,Button")
class B35_2075722Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window title="Grid with Group feature" border="normal">
        <html><![CDATA[
Test Drag-Drop on each panel(The following steps should be true.)<br/>
1.Click the first button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
2.Click the second button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
3.Click the third button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
]]></html>
        <zscript>
          <![CDATA[//@IMPORT
import org.zkoss.zkmax.zul.*;
]]>
          <![CDATA[//@DECLARATION
Portalchildren pc1;
Portalchildren pc2;
List panels = new ArrayList();
void addPortalChidren(){
pc1 = new Portalchildren();
pc2 = new Portalchildren();
pc1.setWidth("60%");
pc2.setWidth("40%");
pc1.setParent(pl);
pc2.setParent(pl);
}

void addPaneltoprotal(Portalchildren pc){
	newPanel(pc);
	newPanel(pc);
	newPanel(pc);
}

void include(Component parent,String name){
}

int count=1;
Panelchildren newPanel(Component parent){
Panel panel = new Panel();
panel.setTitle("panel"+count++);
panel.setHeight("50px");
Panelchildren pc = new Panelchildren();
pc.setParent(panel);
panel.setParent(parent);
panels.add(panel);
return pc;
}
void moveLastPanel(){
if(panels.size()>0){
Panel panel = (Panel)panels.get(panels.size()-1);
if(panel.getParent()==pc1){
panel.setParent(pc2);
}else{
panel.setParent(pc1);
}
}
}

void removeLastPanel(){
if(panels.size()>0){
panels.get(panels.size()-1).detach();
panels.remove(panels.size()-1);
}
}
]]>
          <![CDATA[

]]>
        </zscript>
        <div>
          <button label="1.Add Panels" onClick="addPaneltoprotal(pc1)"/>
          <button label="2.Add Panels" onClick="addPaneltoprotal(pc2)"/>
          <button label="3.move Panel" onClick="moveLastPanel()"/>
          <portallayout id="pl" onCreate="addPortalChidren();">
          </portallayout>
        </div>
      </window>
    }
    runZTL(zscript, () => {
      def dragDrop(from: Element, fromPos: String, to: Element, toPos: String) {
        mouseDownAt(from, fromPos);
        mouseMoveAt(to, toPos);
        mouseUpAt(to, toPos);
        waitResponse();
      }
      var topPanel1, topPanel2, topPanel3, topPanel4, topPanel5, topPanel6 = 0;

      // Click on first button
      click(jq("@button"));
      waitResponse();

      // Mouse over the first panel
      mouseOver(jq(".z-panel-header"));
      waitResponse();

      // Drag & Drop the first panel below the second one
      dragDrop(jq(".z-panel-header:contains(panel1)").get(0), "250,0", jq(".z-panel-header:contains(panel2)").get(0), "50,0");
      waitResponse();

      // Record position of panels
      topPanel1 = jq(".z-panel:contains(panel1)").positionTop();
      topPanel2 = jq(".z-panel:contains(panel2)").positionTop();

      // Verify that panel 1 is below panel 2
      verifyTrue("The panel 1 should be below the panel 2", topPanel1 > topPanel2);

      // Drag & Drop the first panel below the third one
      dragDrop(jq(".z-panel-header:contains(panel1)").get(0), "250,0", jq(".z-panel-header:contains(panel3)").get(0), "50,0");
      waitResponse();

      // Record position of panels
      topPanel1 = jq(".z-panel:contains(panel1)").positionTop();
      topPanel3 = jq(".z-panel:contains(panel3)").positionTop();

      // Verify that panel 1 is below panel 3
      verifyTrue("The panel 1 should be below the panel 3", topPanel1 > topPanel3);

      // Click on second button
      click(jq("@button").get(1));
      waitResponse();

      // Drag & Drop the panel4 below the panel2
      dragDrop(jq(".z-panel-header:contains(panel4)").get(0), "0,0", jq(".z-panel-header:contains(panel2)").get(0), "0,50");
      waitResponse();

      // Record position of panels
      topPanel4 = jq(".z-panel:contains(panel4)").positionTop();
      topPanel2 = jq(".z-panel:contains(panel2)").positionTop();

      // Verify that panel 4 is below panel 2
      verifyTrue("The panel 4 should be below the panel 2", topPanel4 > topPanel2);

      // Drag & Drop the panel3 below the panel5
      dragDrop(jq(".z-panel-header:contains(panel3)").get(0), "0,0", jq(".z-panel-header:contains(panel5)").get(0), "0,50");
      waitResponse();

      // Record position of panels
      topPanel3 = jq(".z-panel:contains(panel3)").positionTop();
      topPanel5 = jq(".z-panel:contains(panel5)").positionTop();

      // Verify that panel 3 is below panel 5
      verifyTrue("The panel 3 should be below the panel 5", topPanel3 > topPanel5);

       // Click on third button
      click(jq("@button").get(2));
      waitResponse();
      
      // Record position of panels
      topPanel1 = jq(".z-panel:contains(panel1)").positionTop();
      topPanel6 = jq(".z-panel:contains(panel6)").positionTop();

      // Verify that panel 6 is below panel 1
      verifyTrue("The panel 6 should be below the panel 1", topPanel6 > topPanel1);

       // Click on third button again
      click(jq("@button").get(2));
      waitResponse();
      
      // Record position of panels
      topPanel3 = jq(".z-panel:contains(panel3)").positionTop();
      topPanel6 = jq(".z-panel:contains(panel6)").positionTop();

      // Verify that panel 6 is below panel 3
      verifyTrue("The panel 6 should be below the panel 3", topPanel6 > topPanel3);

      
   })
  }
}
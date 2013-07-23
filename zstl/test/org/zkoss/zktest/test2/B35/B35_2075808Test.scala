/* B35_2075808Test.scala

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
import org.junit.Test

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2075808.zul,B,E,Window,Button")
class B35_2075808Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript = {
      <zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd">
        <vbox>
          <label value="Orginally, three columns are 50%,20%,30% in width;"/>
          <label value="Use setWidth() in zscript caused the rightmost column been pushed down to next line."/>
        </vbox>
        <zscript><![CDATA[ 
//@IMPORT
import org.zkoss.zkmax.zul.Columnchildren;
                  ]]></zscript>
        <hbox>
          <button id="modify" label="1. adjust width to 20%,20%,30%">
            <attribute name="onClick">
              <![CDATA[ 
			       
			        cLef.setWidth("20%");
			        cMid.setWidth("20%");
			        cRig.setWidth("30%");
			     
			                        ]]>
            </attribute>
          </button>
          <button id="remove" label="2. set back to 50%,20%,30%">
            <attribute name="onClick">
              <![CDATA[ 
			                                   
					cLef.setWidth("50%");
					cMid.setWidth("20%");
					cRig.setWidth("30%");                           
								     
			                        ]]>
            </attribute>
          </button>
        </hbox>
        <columnlayout id="cLay">
          <columnchildren id="cLef" width="50%" style="padding: 5px">
            <panel height="100px" style="margin-bottom:10px" title="column1-1" border="normal" maximizable="true" collapsible="true">
              <panelchildren>Panel</panelchildren>
            </panel>
            <panel height="100px" framable="true" title="column1-2" border="normal" maximizable="true" style="margin-bottom:10px">
              <panelchildren>Panel</panelchildren>
            </panel>
            <panel height="100px" title="column1-3" border="normal" closable="true">
              <panelchildren>Panel</panelchildren>
            </panel>
          </columnchildren>
          <columnchildren id="cMid" width="20%" style="padding: 5px">
            <panel height="400px">
              <panelchildren>
                <borderlayout height="100%" width="100%">
                  <north maxsize="300" size="50%" border="0" splittable="true" collapsible="true">
                    <borderlayout>
                      <west size="25%" border="none" flex="true" maxsize="250" splittable="true" collapsible="true">
                        <div style="background:#B8D335">
                          <label value="25%" style="color:white;font-size:30px"/>
                        </div>
                      </west>
                      <center border="none" flex="true">
                        <div style="background:#E6D92C">
                          <label value="25%" style="color:white;font-size:30px"/>
                        </div>
                      </center>
                      <east size="50%" border="none" flex="true">
                        <label value="Here is a non-border" style="color:gray;font-size:30px"/>
                      </east>
                    </borderlayout>
                  </north>
                  <center border="0">
                    <borderlayout>
                      <west maxsize="600" size="30%" flex="true" border="0" splittable="true">
                        <div style="background:#E6D92C">
                          <label value="30%" style="color:white;font-size:30px"/>
                        </div>
                      </west>
                      <center>
                        <label value="Here is a border" style="color:gray;font-size:30px"/>
                      </center>
                      <east size="30%" flex="true" border="0" collapsible="true">
                        <div style="background:#B8D335">
                          <label value="30%" style="color:white;font-size:30px"/>
                        </div>
                      </east>
                    </borderlayout>
                  </center>
                </borderlayout>
              </panelchildren>
            </panel>
          </columnchildren>
          <columnchildren id="cRig" width="30%" style="padding: 10px">
            <panel title="Data" framable="true" border="normal" style="margin-bottom:10px">
              <panelchildren>
                <grid>
                  <columns>
                    <column label="category"/>
                    <column label="value"/>
                  </columns>
                  <rows>
                    <row>
                      <label id="c0" value="C/C++"/>
                      <decimalbox id="v0" value="21.2" constraint="no empty" onChange="update(0)"/>
                    </row>
                    <row>
                      <label id="c1" value="VB"/>
                      <decimalbox id="v1" value="10.2" constraint="no empty" onChange="update(1)"/>
                    </row>
                    <row>
                      <label id="c2" value="Java"/>
                      <decimalbox id="v2" value="40.4" constraint="no empty" onChange="update(2)"/>
                    </row>
                    <row>
                      <label id="c3" value="PHP"/>
                      <decimalbox id="v3" value="28.2" constraint="no empty" onChange="update(3)"/>
                    </row>
                  </rows>
                </grid>
              </panelchildren>
            </panel>
            <panel border="normal">
              <panelchildren>
                <checkbox label="3D Chart" checked="true" onCheck="mychart.setThreeD(self.isChecked())"/>
                <chart id="mychart" title="Pie Chart Demo" width="320px" type="pie" threeD="true" fgAlpha="128">
                  <attribute name="onClick">
                    <![CDATA[ 
                    Area area = event.getAreaComponent();
							if (area != null){
                      alert("" + area.getAttribute("entity") + ":" + area.getTooltiptext());
                    }
    			]]>
                  </attribute>
                  <zscript><![CDATA[ 
							void update(int rowIndex) { Label lb =
							(Label) self.getFellow("c"+rowIndex);
							Decimalbox db = (Decimalbox)
							self.getFellow("v"+rowIndex);
							model.setValue(lb.value, new
							Double(db.getValue().doubleValue())); }

							PieModel model = new SimplePieModel();
							for(int j=0; j < 4; ++j) { update(j); }
							mychart.setModel(model);
							 ]]></zscript>
                </chart>
              </panelchildren>
            </panel>
          </columnchildren>
        </columnlayout>
      </zk>
    }
    runZTL(zscript, () => {
      val totLay = jq("$cLay").width();
      val cLef = jq("$cLef").width();
      val cMid = jq("$cMid").width();
      val cRig = jq("$cRig").width();

      // Record size proportions of the panels
      val previousProportioncLef = jq("$cLef").width().toDouble / jq("$cLay").width().toDouble;
      val previousProportioncMid = jq("$cMid").width().toDouble / jq("$cLay").width().toDouble;
      val previousProportioncRig = jq("$cRig").width().toDouble / jq("$cLay").width().toDouble;

      // Click on first button
      click(engine.$f("modify"));
      waitResponse();

      // Click on second button
      click(engine.$f("remove"));
      waitResponse();

      // Record new size proportions of the panels
      val lastProportioncLef = jq("$cLef").width().toDouble / jq("$cLay").width().toDouble;
      val lastProportioncMid = jq("$cMid").width().toDouble / jq("$cLay").width().toDouble;
      val lastProportioncRig = jq("$cRig").width().toDouble / jq("$cLay").width().toDouble;

      // Verify that the new proportions are equals than previously
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncLef, lastProportioncLef);
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncMid, lastProportioncMid);
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncRig, lastProportioncRig);
    })
  }
}
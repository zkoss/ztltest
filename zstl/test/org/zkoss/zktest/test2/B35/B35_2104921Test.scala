/* B35_2104921Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 17, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2104921.zul,B,E,Window,Button")
class B35_2104921Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk>
        1. Collapse the East and West sections.
        <separator/>
        2. Click on the collapsed East bar (not the button) to show it.
        <separator/>
        3. Click on the collapsed West bar to show it, and then the East bar will collapse, that is correct.(vice versa)
        <borderlayout height="500px">
          <north title="North" maxsize="300" size="50%" splittable="true" collapsible="true">
            <borderlayout>
              <west title="West" size="25%" flex="true" maxsize="250" splittable="true" collapsible="true">
                <div style="background:#B8D335">
                  <label value="25%" style="color:white;font-size:50px"/>
                </div>
              </west>
              <center border="none" flex="true">
                <div style="background:#E6D92C">
                  <label value="25%" style="color:white;font-size:50px"/>
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
                  <label value="30%" style="color:white;font-size:50px"/>
                </div>
              </west>
              <center>
                <label value="Here is a border" style="color:gray;font-size:30px"/>
              </center>
              <east title="East" size="30%" flex="true" collapsible="true">
                <div style="background:#B8D335">
                  <label value="30%" style="color:white;font-size:50px"/>
                </div>
              </east>
            </borderlayout>
          </center>
        </borderlayout>
      </zk>
    }
    runZTL(zscript, () => {
      // Click on the east button
      click(jq(".z-east-colps"));
      waitResponse(true);
      // Click on the west button
      click(jq(".z-west-colps"));
      waitResponse(true);

      // Click on the East bar
      click(jq(".z-east-colpsd:eq(1)"));
      waitResponse(true);

      // Verify the css style of the east zone. If the style contains the display attribute setted to block, it is visible
      verifyTrue("The east zone should be visible", jq(".z-east:eq(1)").isVisible());

      // Click on the West bar
      click(jq(".z-west-colpsd"));
      waitResponse(true);

      // Verify the css style of the east zone. If the style contains the display attribute setted to none, 
      // it is not visible. So it is correct
      verifyFalse("The east zone should be collapsed", jq(".z-east:eq(1)").isVisible());
    })
  }
}
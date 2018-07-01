/* B35_2075768Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 24, 2011 09:30:00 AM , Created by Fernando Selvatici
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
@Tags(tags = "B35-2075768.zul,B,E,Window,Button")
class B30_2075768Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
        <borderlayout id="b" height="300px">
          <west maxsize="600" size="30%" flex="true" border="0" id="west">
            <div style="background:#E6D92C">
              <label value="30%" style="color:white;font-size:50px"/>
            </div>
          </west>
          <center id="c">
            <label value="Here is a border" style="color:gray;font-size:30px"/>
          </center>
          <east size="30%" flex="true" border="0" collapsible="true">
            <div style="background:#B8D335">
              <label value="30%" style="color:white;font-size:50px"/>
            </div>
          </east>
        </borderlayout>
        <button label="border/nonborder(West)" onClick='if ("normal".equals(west.border)) west.setBorder("none"); else west.setBorder("normal");'/>
        Please click the button to see that the result is expectable.
      </zk>
    """
    runZTL(zscript, () => {
      // Verify that the west zone has no border
      verifyTrue("The west zone should not have a border", jq(".z-west-noborder").exists());

      // Record the width and height values to verify right sizing
      val noBorderHeight: Int = jq(".z-west-noborder").height();
      val noBorderWidth: Int = jq(".z-west-noborder").width();
      // This doesn't work:
      // val noBorderHeight2: Int = jq(engine.$f(".z-west")).height();

      // Click the button to change west zone border
      click(jq("@button"));
      waitResponse();

      // Record the width and height new values 
      val borderHeight: Int = jq(".z-west").height();
      val borderWidth: Int = jq(".z-west").width();

      // Verify that the west zone border is visible
      verifyFalse("The west zone should have a border", jq(".z-west-noborder").exists());

      // Verify the sizing of the zone. It should be 2 pixels smaller (height and width)
      verifyTrue("The height of the west zone should be 2 pixels smaller than without the border", (noBorderHeight - borderHeight) == 2);
      verifyTrue("The width of the west zone should be 2 pixels smaller than without the border", (noBorderWidth - borderWidth) == 2);

      // Click again the button to change west zone border
      click(jq("@button"));
      waitResponse();

      // Verify that the west zone has no border again
      verifyTrue("The west zone should not have a border", jq(".z-west-noborder").exists());

    })
  }
}
/* B30_1894208Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 18, 2011 12:00:00 AM , Created by Fernando Selvatici
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
@Tags(tags = "B30-1894208.zul,B,E,Window,Button")
class B30_1894208Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>North region should be splittable.</n:p>
        <borderlayout height="500px">
          <north size="20%" splittable="true">
            <label value="North Panel" style="color:red;font-size:30px"/>
          </north>
          <west minsize="40" maxsize="300" size="300px" splittable="true" collapsible="true">
            <label value="West Panel" style="color:blue;font-size:30px"/>
          </west>
          <center>
            <label value="Center Panel" style="color:green;font-size:30px"/>
          </center>
          <east size="10%">
            <label value="East Panel" style="color:blue;font-size:30px"/>
          </east>
          <south size="100px" border="0">
            <label value="South Panel" style="color:red;font-size:30px"/>
          </south>
        </borderlayout>
      </zk>
    }
    runZTL(zscript, () => {
      def dragDrop(from: Element, fromPos: String, to: Element, toPos: String) {
        mouseDownAt(from, fromPos);
        mouseMoveAt(to, toPos);
        mouseUpAt(to, toPos);
        waitResponse();
      }

      // Record the height of the north zone before drag (simulation)
      var h1: Int = jq(".z-north").height();

      // Click on north splitter
      click(jq(".z-north-splt").get(0));
      waitResponse();

      dragDrop(jq(".z-north-splt").get(0), "250,0", jq(".z-north-splt").get(0), "250,50");
      waitResponse();

      // Record the height of the north zone after drag
      var h2: Int = jq(".z-north").height();

      // Verify that the diference of the heihts is 50
      verifyTrue(h2-h1==50);


    })
  }
}
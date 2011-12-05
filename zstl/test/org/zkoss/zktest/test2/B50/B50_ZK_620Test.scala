/* B50_ZK_620Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 14:09:58 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-620
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-620.zul,A,E,onSize,VisionTest")
class B50_ZK_620Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<tabbox height="500px" width="500px">
				<custom-attributes org.zkoss.zul.client.rod="false" />
				<tabs>
					<tab label="Definition" />
					<tab label="Discovery" id="tab" />
				</tabs>
				<tabpanels>
					<tabpanel>
					<html><![CDATA[
					<ul>
						<li>Click the Discovery tab, and then you shall see two windows
						in the second panel.</li>
					</ul>
					]]></html>
					</tabpanel>
					<tabpanel>
						<borderlayout>
							<north id="north">
								<window id="window" title="x" vflex="1" border="normal"></window>
							</north>
							
							<center >
								<window title="x" vflex="1" border="normal"></window>
							</center>
							
						</borderlayout>
					</tabpanel>
				</tabpanels>
			</tabbox>

    }


   runZTL(zscript, () => {
   			var tab: Widget = engine.$f("tab");
   			var north: Widget = engine.$f("north");
   			var window: Widget = engine.$f("window");

   			click(tab);
   			waitResponse();

   			verifyTrue("north height should equal to window height",
   			    jq(north.$n("real")).height() == jq(window.$n()).height());
		})
  }
}
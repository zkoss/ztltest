/* B50_ZK_640Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Dec 07 12:37:44 CST 2011 , Created by benbai
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
 * A test class for bug ZK-640
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-640.zul,B,E,Toolbarbutton")
class B50_ZK_640Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    	<zk>
			<html><![CDATA[
			There should no extra "&amp;nbsp;" (see the dom element) after the image of toolbarbutton if no label.
			]]>
			</html>
				<tabbox width="500px">
					<tabs>
						<tab label="Tab 1" />
					</tabs>
					<toolbar id="tbar">
						<toolbarbutton label="label" image="/img/defender.gif" />
						<toolbarbutton label="label" image="/img/defender.gif" />
						<toolbarbutton id="tbbOne" image="/img/live.gif" />
						<toolbarbutton image="/img/live.gif" />
						<toolbarbutton id="tbbTwo" label="label" image="/img/defender.gif" />
						<toolbarbutton image="/img/live.gif" />
						<toolbarbutton label="label" image="/img/defender.gif" />
					</toolbar>
					<tabpanels>
						<tabpanel>This is panel 1</tabpanel>
					</tabpanels>
				</tabbox>
			</zk>

    """
runZTL(zscript, () => {
   			var tbbOne: Widget = engine.$f("tbbOne");
   			var tbbTwo: Widget = engine.$f("tbbTwo");

   			verifyFalse("no extra space if image only",
   			    tbbOne.$n().get("innerHTML").contains("&nbsp;"));
   			verifyTrue("space exists between label and image",
   			    tbbTwo.$n().get("innerHTML").contains("&nbsp;"));
		})
  }
}
/* B50_ZK_804Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 17:52:35 CST 2012 , Created by benbai
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
 * A test class for bug ZK-804
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-804.zul,B,M,Tabpanels")
class B50_ZK_804Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					1. Click on the button. You should NOT see javascript Exception. 
				</div>
				<button id="go" label="Go">
					<attribute name="onClick"><![CDATA[
						Tabpanels tps = new Tabpanels();
						tps.parent = tabbox;
						Tabpanel tp = new Tabpanel();
						tp.parent = tps;
						tp.appendChild(new Label("Tabpanel Content"));
					]]></attribute>
				</button>
				<tabbox id="tabbox">
					<tabs>
						<tab label="Tab" />
					</tabs>
				</tabbox>
			</zk>

    }


   runZTL(zscript, () => {
   			var go: Widget = engine.$f("go");
   			click(go);
   			waitResponse();
   			verifyFalse("should no javascript exception",
   			    jq(".z-error").exists());
		})
  }
}
/* B50_ZK_886Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 15:24:21 CST 2012 , Created by benbai
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
 * A test class for bug ZK-886
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-886.zul,B,E,Tab")
class B50_ZK_886Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>1. Click 'set disabled', then you can open/close Tab2, it should not disappear.</div>
				<div>2. Click 'set closable', then you can open/close/delete Tab2, it should not disappear before you close it.</div>
				<div>3. Refresh page.</div>
				<div>4. Click 'set image', the image of Tab2 should changed, it should not disappear.</div>
				<div>5. Click 'invalidate', Tab2 should not disappear.</div>
				<tabbox id="tabbox" mold="accordion" width="500px">
					<tabs>
						<tab id="tab1" label="Tab1" disabled="false" />
						<tab id="tab2" label="Tab2" image="/img/battery.gif"
							disabled="true" closable="false"  />
					</tabs>
					<tabpanels>
						<tabpanel id="panelOne">
							<button id="btnOne" label="set disabled" >
								<attribute name="onClick"><![CDATA[
									tab2.setDisabled(false);
								]]></attribute>
							</button>
							<button id="btnTwo" label="set closable" >
								<attribute name="onClick"><![CDATA[
									tab2.setClosable(true);
								]]></attribute>
							</button>
							<button id="btnThree" label="set image" >
								<attribute name="onClick"><![CDATA[
									tab2.setImage("/img/defender.gif");
								]]></attribute>
							</button>
							<button id="btnFour" label="invalidate" >
								<attribute name="onClick"><![CDATA[
									tab2.invalidate();
								]]></attribute>
							</button>
						</tabpanel>
						<tabpanel id="panelTwo">
							tab panel 2
						</tabpanel>
					</tabpanels>
				</tabbox>
			</zk>

    }


   runZTL(zscript, () => {
   			var (tab1: Widget,
    	     tab2: Widget,
    	     panelOne: Widget,
    	     panelTwo: Widget,
    	     btnOne: Widget,
    	     btnTwo: Widget,
    	     btnThree: Widget,
    	     btnFour: Widget) = (
    	        engine.$f("tab1"),
    	        engine.$f("tab2"),
    	        engine.$f("panelOne"),
    	        engine.$f("panelTwo"),
    	        engine.$f("btnOne"),
    	        engine.$f("btnTwo"),
    	        engine.$f("btnThree"),
    	        engine.$f("btnFour")
    	    );
   			var closedHeight: Int = jq(panelTwo).height();
   			def doTest (wgt: org.zkoss.ztl.ClientWidget) {
   			  clickAndWeight(wgt);
   			  checkExistAndOpenable();
   			}
   			def clickAndWeight(wgt: org.zkoss.ztl.ClientWidget) {
   			  click(wgt);
   			  waitResponse();
   			}
   			def checkExistAndOpenable () {
   			  click(tab2);
   			  sleep(1000);

   			  verifyTrue("Tab2 should be opened",
   			      jq(panelTwo).height() > closedHeight);
   			  click(tab1);
   			  sleep(1000);

   			  verifyTrue("Tab2 should be closed",
   			      jq(panelTwo).height() == closedHeight
   			      && jq(panelTwo).height() != 0);
   			}

			doTest(btnOne);
			doTest(btnTwo);
			doTest(btnThree);
			doTest(btnFour);
		})
  }
}
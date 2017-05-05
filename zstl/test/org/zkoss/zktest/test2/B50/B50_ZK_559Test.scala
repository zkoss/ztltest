/* B50_ZK_559Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Dec 02 16:12:14 CST 2011 , Created by benbai
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
 * A test class for bug ZK-559
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-559.zul,A,E,Hbox,Vbox,flex")
class B50_ZK_559Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<div>
					Chrome/Safari only. There should be no vertical gap between listbox and tabbox. 
				</div>
				<vbox id="vbox" width="400px" height="700px" style="border: 1px solid #EE1111">
					<hbox id="hbox" vflex="2" hflex="1">
						<listbox id="listbox" hflex="1" vflex="1">
							<listhead>
								<listheader label="Item 1" />
							</listhead>
							<listitem forEach="0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9">
								<listcell label="${each}" />
							</listitem>
						</listbox>
					</hbox>
					<tabbox id="tabbox" vflex="5" hflex="1">
						<tabs>
							<tab label="Tab 1" />
							<tab label="Tab 2" />
						</tabs>
						<tabpanels hflex="1" vflex="1">
							<tabpanel style="overflow:auto" vflex="1" hflex="1" forEach="1,2">
								Tabpanel Content
							</tabpanel>
						</tabpanels>
					</tabbox>
				</vbox>
			</zk>

    """
runZTL(zscript, () => {
   			var listbox: Widget = engine.$f("listbox");
   			var tabbox: Widget = engine.$f("tabbox");

   			var gap: Integer = Math.abs(jq(tabbox.$n()).positionTop() - jq(listbox.$n()).height() - jq(listbox.$n()).positionTop());

   			verifyTrue("the gap between listbox and tabbox should not too large",
   			    gap < 15);
		})
  }

}
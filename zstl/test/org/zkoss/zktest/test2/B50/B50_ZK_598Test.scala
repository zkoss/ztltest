/* B50_ZK_598Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 15:04:37 CST 2011 , Created by benbai
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
 * A test class for bug ZK-598
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-598.zul,A,E,Listbox,Tree,vflex,VisionTest")
class B50_ZK_598Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<zscript>
					Object[] o = new Object[50];
				</zscript>
				<div>
					You should see the red Div occupy the rest of height from the green area.
				</div>
				<div width="500px" height="500px" style="background-color:green">
					<div id="div0" vflex="1" width="400px">
						<div id="div1">
							<listbox rows="7">
								<listitem label="x" forEach="${o}" />
							</listbox>
						</div>
						<div id="div2" vflex="1" hflex="true" style="background-color:red">
							Div
						</div>
					</div>
				</div>
			</zk>

    }


   runZTL(zscript, () => {
			var div0: Widget = engine.$f("div0");
    		var div1: Widget = engine.$f("div1");
    		var div2: Widget = engine.$f("div2");

    		System.out.println(jq(div0.$n()).height());
    		System.out.println(jq(div1.$n()).height());
    		System.out.println(jq(div2.$n()).height());
    		verifyTrue("two inner div should full-fill the outer div",
    		    jq(div0.$n()).height() == (jq(div1.$n()).height() + jq(div2.$n()).height()));
		})
  }
}
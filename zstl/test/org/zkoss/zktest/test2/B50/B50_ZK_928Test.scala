/* B50_ZK_928Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Mar 13 17:25:16 CST 2012 , Created by benbai
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
 * A test class for bug ZK-928
 * @author benbai
 *
 */
@Tags(tags = "##ztl##B50-ZK-928.zul,B,H,Combobox")
class B50_ZK_928Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<combobox id="cb1" value="Apple">
					<comboitem forEach="Apple, Orange, Grape, Banana"
						label="${each }" />
				</combobox>
				<combobox id="cb2"  >
					<comboitem forEach="Apple, Orange, Grape, Banana"
						label="${each }" />
				</combobox>	
				<script>
				/*
				zk.afterMount(function (){
					zk.Widget.$("$cb1")._updnSel({stop:function(){}},false);
					zk.Widget.$("$cb2")._updnSel({stop:function(){}},false);		
				});
				*/
				</script>
				
			</zk>

    """


   runZTL(zscript, () => {
			var cb1: Widget = engine.$f("cb1");
    		var cb2: Widget = engine.$f("cb2");

    		click(cb1.$n("real"));
    		sendKeys(cb1.$n("real"), org.openqa.selenium.Keys.ARROW_DOWN);
    		waitResponse();
    		verifyTrue(cb1.$n("real").get("value").equals("Apple"));
    		click(cb2.$n("real"));
    		sendKeys(cb2.$n("real"), org.openqa.selenium.Keys.ARROW_DOWN);
    		waitResponse();
    		verifyTrue(cb2.$n("real").get("value").equals("Apple"));
		})
  }
}
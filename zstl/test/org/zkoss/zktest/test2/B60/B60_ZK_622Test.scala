/* B60_ZK_622Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 29 12:18:42 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
 * A test class for bug ZK-622
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-622.zul,B,E,Radio,JQuery,Selector")
class B60_ZK_622Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<window id="w" mode="modal" xmlns:n="http://www.zkoss.org/2005/zk/native" width="500px">
				<n:p>Please click the "female" radio, and then click the "show" button, and then you should see that only "female" is checked and the label "undefined" is shown</n:p>
				<radiogroup id="radiochoice">
					<radio id="male1" label="male" checked="true" />
					<radio id="female" label="female" />
				</radiogroup>
				 <button id="btn" label="show" xmlns:w="client" w:onClick='this.$f("log").setValue(jq("$male1 input").attr("checked")+"");'/>
				 <label id="log"/>
			</window>

    """
runZTL(zscript,
        () => {
        var male1: Widget = engine.$f("male1");
        var female: Widget = engine.$f("female");
        var btn: Widget = engine.$f("btn");
        var log: Widget = engine.$f("log");

        // skip ie6/7, browser issue
        if (!ZK.is("ie6_") && !ZK.is("ie7_")) {
	        click(female.$n("real"));
	        click(btn); waitResponse();
	        verifyTrue("mail should not be checked",
	            male1.$n("real").get("checked").equals("false"));
	        verifyTrue("label 'undefined' is shown",
	            log.$n().get("innerHTML").contains("undefined"));
        }
    }
   );
  }
}
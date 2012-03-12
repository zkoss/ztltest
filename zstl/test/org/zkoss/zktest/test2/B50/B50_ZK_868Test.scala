/* B50_ZK_868Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 17:27:23 CST 2012 , Created by benbai
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
 * A test class for bug ZK-868
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-868.zul,B,E,Button")
class B50_ZK_868Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>1. You should see a 'test' button, a 'Upload' button and a label 'result: '</div>
				<div>2. Click 'test' button, the label should become '0px'</div>
				<button id="btn" label="test" mold="trendy">
					<attribute name="onClick">
						Clients.evalJavaScript("jq('$lb')[0].innerHTML = jq('$fileupload').find('.z-button-tl').css('font-size');");
					</attribute>
				</button>
				<fileupload id="fileupload" mold="trendy" label="Upload" />
				<label id="lb" value="result: " />
			</zk>

    }


   runZTL(zscript, () => {
   			var (btn: Widget,
    	     lb: Widget) = (
    	        engine.$f("btn"),
    	        engine.$f("lb")
    	    );
			click(btn);
			waitResponse();
			verifyTrue("Font-size should be 0px",
			    lb.$n().get("innerHTML").contains("0px"));
		})
  }
}
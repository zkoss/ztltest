/* B50_ZK_822Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 17:01:22 CST 2012 , Created by benbai
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
 * A test class for bug ZK-822
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-822.zul,B,E,Group,EventQueue")
class B50_ZK_822Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<zscript>
				EventQueue que = EventQueues.lookup("iframe", "group", true);
				void publish() {
					String text = tbx.getValue();
					que.publish(new Event("onGroupTest", null, text));
				}
				</zscript>
				<vlayout>
					<div>
						Please type some words into the textbox and press ENTER.
						Then, if there is no exception, it is correct.
						<textbox id="tbx" onChange="publish()" onOK="publish()"/>
					</div>
					<iframe width="400px" height="600px" src="/test2/B50-ZK-822-iframe.zul" />
				</vlayout>
			</zk>

    """


   runZTL(zscript, () => {
			var tbx: Widget = engine.$f("tbx");
    		var input: Element = tbx.$n();
    		focus(input);
    		sendKeys(input, "abc"+org.openqa.selenium.Keys.ENTER);
    		waitResponse();
    		verifyFalse("should no exception",
        			jq(".z-window-modal").exists());
		});
  }
 
}
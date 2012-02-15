/* B50_ZK_812Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 17:38:02 CST 2012 , Created by benbai
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
 * A test class for bug ZK-812
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-812.zul,B,E,wire")
class B50_ZK_812Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					You should not see java error.
					<window id="win" title="Window">
						<label id="lb" value="Label" />
					</window>
				</div>
				<zscript>
					Components.wireFellows(win, new Object());
				</zscript>
			</zk>

    }


   runZTL(zscript, () => {
   			var lb: Widget = engine.$f("lb");
   			verifyTrue("The page should rendered correctly",
   			    lb.exists());
   			verifyFalse("should no exception",
        			jq(".z-window-modal").exists());
		})
  }
  /* get alert value
  	jq(".z-messagebox").find(".z-label").get(0).get("innerHTML")
  */
  /* click then wait response
  	def clickAndWait = (target: org.zkoss.ztl.ClientWidget) => {
		click(target);
		waitResponse();
	}
  */
}
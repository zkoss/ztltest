/* B50_ZK_842Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 15:30:41 CST 2012 , Created by benbai
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
 * A test class for bug ZK-842
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-842.zul,B,M,message")
class B50_ZK_842Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<zscript>
					Clients.reloadMessages(null);
				</zscript>
				<div id="di">
					Enter '00' in the Intbox below and click on somewhere else. You should see an error message. Otherwise it is a bug.
				</div>
				<intbox id="ibx" />
			</zk>

    }

   runZTL(zscript,
        () => {
        var di: Widget = engine.$f("di");
        var ibx: Widget = engine.$f("ibx");
        focus(ibx);
        sendKeys(ibx, "00");
        blur(ibx);
        waitResponse();
        verifyTrue("error box should appear",
            jq(".z-errbox").exists());
    }
   );
  }
}
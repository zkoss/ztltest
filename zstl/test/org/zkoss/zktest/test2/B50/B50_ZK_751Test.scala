/* B50_ZK_751Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 14 11:05:12 CST 2012 , Created by benbai
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
 * A test class for bug ZK-751
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-751.zul,B,E,Button,Upload")
class B50_ZK_751Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>Mouseover the button below, a tooltiptext should appear.</div>
				<button label="TEST LABEL" tooltiptext="popup" upload="true"></button>
			</zk>

    }

    def executor() = {
    	
    }
   runZTL(zscript,
        () => {
        verifyTrue("Upload should has title",
		        "popup".equals(jq(".z-upload").get(0).get("title")));
    }
   );
  }
}
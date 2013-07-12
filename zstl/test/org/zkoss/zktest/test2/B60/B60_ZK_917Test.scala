/* B60_ZK_917Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 16:07:32 CST 2012 , Created by benbai
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
 * A test class for bug ZK-917
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-917.zul,A,E,Hflex,Vflex")
class B60_ZK_917Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					Blue color should fill the entire region bound by red border.
				</div>
				<div id="div1" width="500px" height="500px" style="border: 1px solid #FF0000">
					<div id="div2" style="background: #333399" hflex="1" vflex="1" />
					<div style="position: absolute; top: 100px; left: 100px; border: 1px solid #00FF00;" 
						width="100px" height="100px" />
				</div>
			</zk>

    }

    runZTL(zscript,
        () => {
        var div1: Widget = engine.$f("div1");
        var div2: Widget = engine.$f("div2");

        verifyTrue("Blue color should fill the entire region bound by red border.",
            (jq(div1).height() - jq(div2).height()) <= 2
            && (jq(div1).width() - jq(div2).width()) <= 2);
    }
   );
  }
}
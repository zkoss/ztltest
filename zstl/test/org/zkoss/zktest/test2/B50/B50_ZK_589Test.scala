/* B50_ZK_589Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Nov 30 18:18:10 CST 2011 , Created by benbai
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
 * A test class for bug ZK-589
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-589.zul,B,E,Window,Hlayout")
class B50_ZK_589Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
				<hlayout hflex="min">
					<window id="win" border="normal" vflex="min" hflex="min">
						<div>
							IE7 only. <div />
							The top/bottom border of this window should not disappeared.<div />
							(should looks like the left/right border)
						</div>
					</window>
				</hlayout>
			</zk>

    }

   runZTL(zscript, () => {
			var win: Widget = engine.$f("win");

    		verifyTrue("the width of top/bottom border should larger then cave width",
    		    jq(win).width() >  jq(win.$n("cave")).width());
		})
  }
}
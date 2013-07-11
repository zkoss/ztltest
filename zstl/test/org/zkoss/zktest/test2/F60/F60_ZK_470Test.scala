/* F60_ZK_470Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 18:06:09 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

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
 * A test class for bug ZK-470
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-470.zul,F60,A,E,Anchorlayout")
class F60_ZK_470Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
			    <window id="parent" title="anchorlayout Demo" border="normal" width="100%" height="100%">
			    		You should see the following layout display as its description that is according to its parent size.
			            <anchorlayout id="al" width="100%" vflex="1" style="overflow:auto">
			                <anchorchildren height="200px" anchor="-100">
			                    <window id="win1" title="win1" border="normal" width="100%" height="100%">
			                        height is "200px" and width is its parent size minus 100
			                    </window>
			                </anchorchildren>
			                <anchorchildren anchor="50% -200">
			                    <window id="win2" title="win2" border="normal" width="100%" height="100%">
			                       width is its parent size's 50%, and height is its parent size minus 200
			                    </window>
			                </anchorchildren>
			                <anchorchildren anchor="25% 20%">
			                    <window id="win3" title="win3" border="normal" width="100%" height="100%">
			                    width is its parent size's 25%, and height is its parent size's 20%
			                    </window>
			                </anchorchildren>
			                <anchorchildren anchor="25% 20%">
			                    <window id="win4" title="win4" border="normal" width="100%" height="100%">
			                    width is its parent size's 25%, and height is its parent size's 20%
			                    </window>
			                </anchorchildren>
			                <anchorchildren anchor="25% 20%">
			                    <window id="win5" title="win5" border="normal" width="100%" height="100%">
			                    width is its parent size's 25%, and height is its parent size's 20%
			                    </window>
			                </anchorchildren>
			                <anchorchildren anchor="25% 20%">
			                    <window id="win6" title="win6" border="normal" width="100%" height="100%">
			                    width is its parent size's 25%, and height is its parent size's 20%
			                    </window>
			                </anchorchildren>
			            </anchorlayout>
			    </window>
			</zk>

    }

    runZTL(zscript,
        () => {
        var al: Widget = engine.$f("al");
        var win1: Widget = engine.$f("win1");
        var win2: Widget = engine.$f("win2");
        var win3: Widget = engine.$f("win3");
        var win4: Widget = engine.$f("win4");
        var win5: Widget = engine.$f("win5");
        var win6: Widget = engine.$f("win6");

        var parentW: Double = jq(al.$n()).width();
        var parentH: Double = jq(al.$n()).height();

        def checkSize (win: Widget, winW: Double, winH: Double) {
          verifyTrue("Ths window size should be "+winW+", "+winH,
              math.abs(jq(win).outerWidth() - winW) < 2 && math.abs(jq(win).outerHeight() - winH) < 2);
        }
        checkSize(win1, parentW - 100, 200);
        checkSize(win2, parentW*0.5, parentH - 200);
        checkSize(win3, parentW*0.25, parentH*0.2);
        checkSize(win4, parentW*0.25, parentH*0.2);
        checkSize(win5, parentW*0.25, parentH*0.2);
        checkSize(win6, parentW*0.25, parentH*0.2);
    }
   );
  }
}
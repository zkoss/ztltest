/* B50_3303684Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 17:50:33 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Element, Tags, Widget}

/**
  * A test class for bug 3303684
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3303684.zul,A,E,Panel,DragDrop")
class B50_3303684Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<panel id="pa" sizable="true" width="500px" height="500px"
					movable="true" border="rounded+" floatable="true">
					<panelchildren>
						<html><![CDATA[
							<ol>
								<li>You should be able to reduce the height of the Panel. If not, it is a bug.</li>
							</ol>
						]]></html>
					</panelchildren>
				</panel>
			</zk>

    """
    runZTL(zscript,
      () => {
        var pa: Widget = engine.$f("pa");

        def dragDrop(from: Element, fromPos: String, to: Element, toPos: String) {
          mouseDownAt(from, fromPos);
          mouseMoveAt(to, toPos);
          mouseUpAt(to, toPos);
          waitResponse();
        }

        var h1: Int = jq(pa.$n()).outerHeight();
        dragDrop(jq(".z-panel").get(0), "250,0", jq(".z-panelchildren").get(0), "250,380");
        waitResponse();
        var h2: Int = jq(pa.$n()).outerHeight();
        verifyTrue("the old height is (" + h1
          + "), the new height should smaller then (" + (h1 - 100) + ")",
          (h1 - h2) > 100);
      }
    );

  }
}
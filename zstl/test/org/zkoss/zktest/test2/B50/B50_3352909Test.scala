/* B50_3352909Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 12:37:32 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug 3352909
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3352909.zul,A,E,Grid,Listbox,ROD,Scrollbar")
class B50_3352909Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
			1. Plese scroll to item99(or more than it), it shouldn't jump to item 41.
			<zscript>
			Object[] o = new Object[200];
			</zscript>
			<listbox id="lb" width="100px" height="100px">
			<listitem forEach="${o}" label="item ${forEachStatus.index}" />
			</listbox>
			<grid id="grid" width="100px" height="100px">
			<rows>
			<row forEach="${o}">
			<label value="item ${forEachStatus.index}"/>
			</row>
			</rows>
			</grid>
			</zk>

    """

    def executor = () => {
      var lb: Widget = engine.$f("lb")
      var grid: Widget = engine.$f("grid")
      waitResponse()

      verScroll(lb, 0.5)
      waitResponse()
      verifyTrue(jq(lb.$n("body")).scrollTop() > 2000)

      verScroll(grid, 0.5)
      waitResponse()
      sleep(500)
      verifyTrue(jq(grid.$n("body")).scrollTop() > 2000)
    }

    runZTL(zscript, executor);

    // Run syntax 2
    /**
      * runZTL(zscript,
      * () => {
      * var l1: Widget = engine.$f("l1");
      * var l2: Widget = engine.$f("l2");
      * waitResponse();
      * var strClickBefor = getText(l1);
      * click(l1);
      * waitResponse();
      * verifyNotEquals(strClickBefor, getText(l1));
      * strClickBefor = getText(l2);
      * click(l2);
      * waitResponse();
      * verifyNotEquals(strClickBefor, getText(l2));
      * }
      * );
      */
    /** create widget example
      * var tree: Widget = engine.$f("tree");
      * var listbox: Widget = engine.$f("listbox");
      * waitResponse();
      */
    /** trigger mouse event example
      *Scripts.triggerMouseEventAt(getWebDriver(), inner1, "click", "5,5");
      */
    /** detect whether exception exists example
      * verifyFalse(jq(".z-window-highlighted").exists());
      * verifyFalse(jq(".z-window-modal").exists())
      */

  }
}
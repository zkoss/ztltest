/* B50_ZK_306Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 17:26:14 PM , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.util.Scripts

/**
  * A test class for bug ZK-306
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-306.zul,A,E,Tree,TreeModel")
class B50_ZK_306Test extends ZTL4ScalaTestCase {

  def testClick() = {
    def executor = () => {
      var btn: Widget = engine.$f("btn");
      var btn2: Widget = engine.$f("btn2");
      var tree: Widget = engine.$f("tree");
      var tree2: Widget = engine.$f("tree2");
      var tb: Widget = engine.$f("tb");
      var tb2: Widget = engine.$f("tb2");
      waitResponse();

      clickItem(tree, 1);
      waitResponse();
      clickAt(btn, "5,5");
      waitResponse();
      checkNumber(tb, 1);
      clickItem(tree, 3);
      waitResponse();
      clickAt(btn, "5,5");
      waitResponse();
      checkNumber(tb, 1);

      clickItem(tree2, 1);
      waitResponse();
      clickItem(tree2, 2);
      waitResponse();
      clickItem(tree2, 3);
      waitResponse();
      clickAt(btn2, "5,5");
      waitResponse();
      checkNumber(tb2, 3);

      clickItem(tree2, 2);
      waitResponse();
      clickAt(btn2, "5,5");
      waitResponse();
      checkNumber(tb2, 2);
    }

    def clickItem(wgt: Widget, index: java.lang.Integer) {
      click(jq(wgt.$n("body")).find(".z-treerow").get(index));
    }

    def checkNumber(wgt: Widget, cnt: java.lang.Integer) {
      verifyEquals(getEval("getAnnotCnt(" + wgt.$n() + ")"), cnt + 1)
    }

    runZTL(executor);

  }
}
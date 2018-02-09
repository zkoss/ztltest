/* B50_ZK_332Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 18:15:14 PM , Created by benbai
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
  * A test class for bug ZK-332
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-332.zul,A,E,Tree,disabled,open")
class B50_ZK_332Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var tree: Widget = engine.$f("tree")
      var tr: Widget = engine.$f("tr")
      waitResponse()
      click(jq(tr.$n("open")))
      waitResponse()
      verifyEquals(2, jq(tree.$n("rows")).find(".z-treerow").length())
      click(jq(tr.$n("open")))
      waitResponse()
      verifyEquals("" ,jq(tree.$n("rows")).find(".z-treerow").get(2).get("style.display"))
      verifyEquals("" ,jq(tree.$n("rows")).find(".z-treerow").get(3).get("style.display"))
    })
  }
}
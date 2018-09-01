/* F51_ZK_216_treeTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 17:24:37 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import java.lang._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-216-tree
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-216-tree.zul,F60,A,E,template,tree")
class F51_ZK_216_treeTest extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var trOne: Widget = engine.$f("trOne");
      var trTwo: Widget = engine.$f("trTwo");

      def clickAndVerify(node: String, child: String, actor: Widget, checker: Widget, toOpen: Boolean) {
        var $nodeOne = jq(actor.$n("body")).find(".z-treerow:contains(" + node + ")")
        var $nodeTwo = jq(checker.$n("body")).find(".z-treerow:contains(" + node + ")")
        var $childOne: JQuery = null
        var $childTwo: JQuery = null
        var status: String = ""
        if (toOpen) {
          status = "opened"
        } else {
          status = "closed"
        }
        click($nodeOne.toWidget().$n("open"))
        waitResponse(true)
        // check only
        verifyTrue("Act icon should exists", $nodeOne.toWidget().$n("open").exists())
        verifyTrue("Act icon should exists", $nodeTwo.toWidget().$n("open").exists())
        $childOne = jq(actor.$n("body")).find(".z-treerow:contains(" + child + ")")
        $childTwo = jq(checker.$n("body")).find(".z-treerow:contains(" + child + ")")
        verifyEquals("Should " + status, toOpen, $childOne.exists() && $childTwo.exists() && isVisible($childOne) == isVisible($childTwo))
      }

      clickAndVerify("/dist", "/src", trOne, trTwo, true)
      clickAndVerify("/lib", "zk.jar", trTwo, trOne, true)
      clickAndVerify("/lib", "zk.jar", trOne, trTwo, false)
      clickAndVerify("/dist", "/src", trTwo, trOne, false)
    })
  }
}
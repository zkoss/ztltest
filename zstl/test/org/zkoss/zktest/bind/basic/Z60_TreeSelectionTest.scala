/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TreeSelectionTest extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/basic/tree-selection.zul"/>
"""

    runZTL(zul, () => {
      var tree = jq("$tree")
      var msg = jq("$msg")
      var selected = jq("$selected")
      var clean = jq("$clean")
      var select = jq("$select")
      var reload = jq("$reload")
      var select0 = jq("$select0")
      var select1 = jq("$select1")
      var showselect = jq("$showselect")
      click(jq("$A-0-1").toWidget().firstChild()) // treeitem->treerow
      waitResponse()
      verifyEquals("A-0-1", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[0, 1]", msg.toWidget().get("value"))
      click(jq("$A-1-0-1").toWidget().firstChild()) // treeitem->treerow
      waitResponse()
      verifyEquals("A-1-0-1", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[1, 0, 1]", msg.toWidget().get("value"))
      click(clean.toWidget())
      waitResponse()
      verifyEquals("", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("no selection", msg.toWidget().get("value"))
      click(select.toWidget())
      waitResponse()
      verifyEquals("A-1-1-1", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[1, 1, 1]", msg.toWidget().get("value"))
      click(select0.toWidget())
      waitResponse()
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[0, 1]", msg.toWidget().get("value"))
      click(reload.toWidget())
      waitResponse()
      verifyEquals("A-1-1-1", selected.toWidget().get("value"))
      verifyEquals("reloaded A-1-1-1", msg.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[1, 1, 1]", msg.toWidget().get("value"))
      click(select1.toWidget())
      waitResponse()
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[0, 1, 1]", msg.toWidget().get("value"))
      click(reload.toWidget())
      waitResponse()
      verifyEquals("A-1-1-1", selected.toWidget().get("value"))
      verifyEquals("reloaded A-1-1-1", msg.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[1, 1, 1]", msg.toWidget().get("value"))
    })
  }
}
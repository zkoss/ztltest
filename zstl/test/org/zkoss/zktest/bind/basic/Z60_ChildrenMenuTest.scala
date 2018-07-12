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
import java.util.ArrayList

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ChildrenMenuTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/children-menu.zul"/>
    """

    runZTL(zul, () => {
      var nodes = new ArrayList[Node]()
      nodes.add(createMenuNode("Item A", 0, 0))
      nodes.add(createMenuNode("Item B", 1, 1))
      nodes.add(createMenuNode("Item C", 2, 2))
      nodes.add(createMenuNode("Item D", 3, 3))
      var mbar = jq("$mbar").toWidget()
      testMenu(nodes, mbar)
    })
  }

  def testMenu(nodes: ArrayList[Node], parent: Widget)=
    {
      var children = parent.firstChild()
      verifyEquals(nodes.size(), parent.nChildren())
      var w = children
      for (i <- 0 to nodes.size() - 1) {
        var n = nodes.get(i)
        verifyEquals(n.getName(), w.get("label"))
        if (n.getChildren().size() == 0)
          verifyEquals("zul.menu.Menuitem", w.eval("className"))
        else {
          verifyEquals("zul.menu.Menu", w.eval("className"))
          click(w) // need to click if menu is in menu bar
          waitResponse()
          // show menu popup
          w.firstChild().eval("open()")
          waitResponse()
          testMenu(n.getChildren(), w.firstChild())
        }
        w = w.nextSibling()
      }
    }

  def createMenuNode(name: String, children: Int, nested: Int): Node =
    {
      var n = new Node(name)
      if (nested > 0) {
        for (i <- 0 to children - 1) {
          var cnt = children;
          if (i == children - 1)
            cnt = 0
          n.addChild(createMenuNode(name + "_" + i, cnt, nested - 1))
        }
      }
      return n
    }

  class Node(n: String) {
    var name = n
    var children = new ArrayList[Node]()

    def addChild(node: Node) {
      children.add(node)
    }

    def getChildren() = children

    def getName() = name
  }
}

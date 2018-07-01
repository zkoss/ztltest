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
class Z60_ChildrenComplexTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/children-complex.zul"/>
    """
    runZTL(zul, () => {
      var nodes = new ArrayList[Node]()
      nodes.add(createNode("Item A", 0, 0))
      nodes.add(createNode("Item B", 3, 1))
      nodes.add(createNode("Item C", 2, 2))
      var layout = jq("$vlayout").toWidget()
      testComplex(nodes, layout, true)
    })
  }
  def testComplex(nodes: ArrayList[Node], parent: Widget, children1: Boolean): Unit = {
    var children = parent.firstChild()
    verifyEquals(nodes.size, parent.nChildren())
    var w = children
    for (i <- 0 to nodes.size - 1) {
      var n = nodes.get(i)
      var str = "children1"
      if (!children1)
        str = "children2"
      verifyEquals(str, w.get("sclass"))
      var l = w.firstChild()
      verifyEquals(n.getName(), l.get("value"))
      var l2 = l.nextSibling()
      testComplex(n.getChildren(), l2, !children1)
      w = w.nextSibling()
    }
  }

  def createNode(name: String, children: Int, nested: Int): Node =
    {
      var n = new Node(name)
      if (nested > 0) {
        for (i <- 0 to children - 1)
          n.addChild(createNode(name + "_" + i, children, nested - 1))
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
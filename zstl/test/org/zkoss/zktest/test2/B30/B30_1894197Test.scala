/* B30_1894197Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 17, 2012 09:30:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1894197.zul,B,E,Window,Button")
class B30_1894197Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
    	<html><![CDATA[
			<ol>
				<li>Click on "setOpen" Button. You shall see node Root, A, B.</li>
				<li>If you did not see A or B, it is a bug.</li>
			</ol>
		]]></html>
		<window title="Dynamically Change by Model">
			<zscript><![CDATA[
				class MySimpleTreeNode extends DefaultTreeNode {
					private String myData = null;
					public MySimpleTreeNode(String data, List children) {
						super(data, children);
						myData = data.toString();
					}
					public String toString() {
						return "Node: " + myData;
					}
					public void append(String data) {
						myData = myData + data;
					}
					public Object getData() {
						return myData;
					}
				}
				List aChildren = new ArrayList();
				List empty = new ArrayList();
				List a2Children = new ArrayList();
				MySimpleTreeNode a20 = new MySimpleTreeNode("A2-0", empty);
				MySimpleTreeNode a21 = new MySimpleTreeNode("A2-1", empty);
				MySimpleTreeNode a22 = new MySimpleTreeNode("A2-2", empty);
				a2Children.add(a20);
				a2Children.add(a21);
				a2Children.add(a22);
				MySimpleTreeNode a0 = new MySimpleTreeNode("A0", empty);
				MySimpleTreeNode a1 = new MySimpleTreeNode("A1", empty);
				MySimpleTreeNode a2 = new MySimpleTreeNode("A2", a2Children);
				aChildren.add(a0);
				aChildren.add(a1);
				aChildren.add(a2);
				List children = new ArrayList();
				MySimpleTreeNode a = new MySimpleTreeNode("A", aChildren);
				children.add(a);
				List bChildren = new ArrayList();
				MySimpleTreeNode b0 = new MySimpleTreeNode("B0", empty);
				MySimpleTreeNode b1 = new MySimpleTreeNode("B1", empty);
				MySimpleTreeNode b2 = new MySimpleTreeNode("B2", empty);
				bChildren.add(b0);
				bChildren.add(b1);
				bChildren.add(b2);
				MySimpleTreeNode b = new MySimpleTreeNode("B", bChildren);
				children.add(b);
				List rList = new ArrayList();
				rList.add(a);
				rList.add(b);
				MySimpleTreeNode r = new MySimpleTreeNode("Root", rList);
				List rootList = new ArrayList();
				rootList.add(r);
				MySimpleTreeNode root = new MySimpleTreeNode("Root", rootList);
				DefaultTreeModel stm = new DefaultTreeModel(root);
				public void setOpen() {
					Treeitem it = (Treeitem) tree.getItems().iterator().next();
					it.setOpen(true);
				}
			]]></zscript>
			<vbox>
				<tree model="${stm}" id="tree" width="700PX"></tree>
				<hbox>
					<button label='setOpen' onClick='setOpen()' />
				</hbox>
			</vbox>
		</window>
	</zk>
    """
    runZTL(zscript, () => {
      var tree: Widget = engine.$f("tree");
      // Record the row count
      val count = jq(".z-treerow").length();

      // Verify that the tree rows visible are only 1 (the root node, before we click the node)
      verifyTrue("It should be visible only the root node", count == 1);

      // Click on setOpen button
      click(jq("@button"));
      waitResponse();

      val countAfter = jq(".z-treerow").length();
      verifyTrue("It should be visible the root and two child nodes (3)", countAfter == 3);

      // Verify that nodes are visible
      verifyTrue("It should be visible the 'Node: A' node", jq(".z-treecell").text().contains("Node: A"));
      verifyTrue("It should be visible the 'Node: B' node", jq(".z-treecell").text().contains("Node: B"));
    })
  }
}
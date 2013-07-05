/* F60_ZK_701_TreeTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Feb 20 17:07:35 CST 2012 , Created by benbai
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
 * A test class for bug ZK-701-Tree
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-701-Tree.zul,F60,A,E,Cloneable,Tree,TreeModel")
class F60_ZK_701_TreeTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<vbox id="vb">
				1. Please select one item on the tree.
				<separator />
				2. Press the "Clone" button (it should not show any exception)
				<separator />
				3. Please select another item on the top tree and then click the "Path" head to sort it.
				<separator />
				4. The sorting and the selection cannot apply to the bottom list. (That is the feature)
				<button id="btn" label="Clone">
					<attribute name="onClick">{
				Object l = tree.clone();
				l.setId("dst" + ++cnt);
				vb.insertBefore(l, self);
					}</attribute>
				</button>
			    <zscript><![CDATA[
			import org.zkoss.zk.ui.util.ComponentCloneListener;
			  int cnt = 0;
			public class CloneableModel extends org.zkoss.zul.DefaultTreeModel implements ComponentCloneListener, Cloneable {
				public CloneableModel(Object d) {
					super(d);
				}
				public Object willClone(Component comp) {
					return clone();
				}
			}
				TreeitemRenderer render = new org.zkoss.zktest.test2.tree.DirectoryTreeitemRenderer();
				DefaultTreeModel model = new CloneableModel(org.zkoss.zktest.test2.tree.PackageData.getRoot());
			    ]]></zscript>
			    <tree id="tree" width="830px" itemRenderer="${render}" model="${model}">
					<treecols>
						<treecol hflex="3" label="Path" sort="auto"/>
						<treecol hflex="5" label="Description" />
						<treecol hflex="2" label="Size" />
					</treecols>
				</tree>
				</vbox>
			</zk>

    """

   runZTL(zscript,
        () => {
        var tree: Widget = engine.$f("tree");
        var btn: Widget = engine.$f("btn");
        var clonedTree: Widget = null;

        def clickAndWait (wgt: org.zkoss.ztl.ClientWidget) {
            click(wgt);
            waitResponse();
        }
        def selectItem(wgt: Widget, content: String) {
            clickAndWait(jq(wgt).find(".z-treerow:contains("+content+")"));
        }
        def isSelected(wgt: Widget, content: String, selected: Boolean) {
        	if (selected)
	            verifyTrue("The item contains "+content+" should be selected",
	                jq(wgt).find(".z-treerow-selected:contains("+content+")").exists());
        	else
        		verifyFalse("The item contains "+content+" should not be selected",
	                jq(wgt).find(".z-treerow-selected:contains("+content+")").exists());
        }
        def verifyOrder (wgt: Widget, content: String, order: Int) {
            verifyTrue("The "+order+" th element should contains "+content,
                jq(wgt).find(".z-treerow").get(order).get("innerHTML").contains(content));
        }

        selectItem(tree, "/src");
        clickAndWait(btn);
        clonedTree = widget(jq(jq(".z-tree").get(0)));

        isSelected(tree, "/src", true);
        isSelected(clonedTree, "/src", true);

        selectItem(clonedTree, "/doc");
        clickAndWait(jq(clonedTree).find(".z-treecol:contains(Path)").get(0));
        isSelected(tree, "/doc", false);
        isSelected(clonedTree, "/doc", true);
        verifyOrder(tree, "/doc", 0);
        verifyOrder(clonedTree, "/doc", 5);

    }
   );
  }
}
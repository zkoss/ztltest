/* B60_ZK_767Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Feb 16 18:18:53 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.ClientWidget;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-767
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-767.zul,A,E,Tree,Template,TreeModel,TreeSelectableModel,TreeOpenableModel")
class B60_ZK_767Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<zscript><![CDATA[//@DECLARATION
			       	class MyTreeNode extends org.zkoss.zul.DefaultTreeNode {
			       		public MyTreeNode(String data, MyTreeNode[] children) {
			      			super(data, children);
			      		}
			      		public MyTreeNode(String data) {
			      			super(data);
			      		}
			      	}
				]]></zscript>
				<zscript><![CDATA[
					MyTreeNode root = new MyTreeNode("Root", new MyTreeNode[] {});
					String[] labs = new String[] { "A", "B", "C" };
					for (int i = 0; i < 3; i++) {
						MyTreeNode ni = new MyTreeNode(labs[i] + i, new MyTreeNode[] {});
						for (int j = 0; j < 3; j++) {
							MyTreeNode nj = new MyTreeNode(ni.getData() + "-" + j, new MyTreeNode[] {});
							for (int k = 0; k < 2; k++)
								nj.add(new MyTreeNode(nj.getData() + "-" + k));
							ni.add(nj);
						}
						root.add(ni);
					}
					org.zkoss.zul.DefaultTreeModel model = new org.zkoss.zul.DefaultTreeModel(root);
					org.zkoss.zul.DefaultTreeModel model2 = new org.zkoss.zul.DefaultTreeModel(root);
					model.addSelectionPath(new int[] { 1, 1 });
					model.addOpenPath(new int[] { 0, 1 });
				]]></zscript>
				<div>
					<div>1. Open A0 in Tree 1. You should see A0-1 already opened.</div>
					<div>2. Open B1 in Tree 1. You should see B1-1 already selected.</div>
					<div>3. Click "Open 0,1", and open A0 in Tree 2. You should see A0-1 already opened.</div>
					<div>4. Click "Select 1,1", and open B1 in Tree 2. You should see B1-1 already selected.</div>
				</div>
				<separator />
				Tree 1
				<tree id="treeOne" model="${model}" width="500px">
					<treecols>
						<treecol label="name"/>
					</treecols>
					<template name="model" >
						<treeitem value="${each}">
							<treerow>
								<treecell label="${each.data}"/>
							</treerow>
						</treeitem>
					</template>
				</tree>
				Tree 2
				<tree id="treeTwo" model="${model2}" width="500px">
					<treecols>
						<treecol label="name"/>
					</treecols>
					<template name="model" >
						<treeitem value="${each}">
							<treerow>
								<treecell label="${each.data}"/>
							</treerow>
						</treeitem>
					</template>
				</tree>
				<hlayout>
					<button id="btnOne" label="Open 0,1" onClick="model2.addOpenPath(new int[]{0,1})" />
					<button id="btnTwo" label="Select 1,1" onClick="model2.addSelectionPath(new int[]{1,1})" />
				</hlayout>
			</zk>

    }

   runZTL(zscript,
        () => {
        var treeOne: Widget = engine.$f("treeOne");
        var treeTwo: Widget = engine.$f("treeTwo");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");

        var treeOneIcoA = jq(treeOne.$n()).find(".z-treerow:contains(A0)").toWidget().$n("icon");
        var treeOneIcoB = jq(treeOne.$n()).find(".z-treerow:contains(B1)").toWidget().$n("icon");
        var treeTwoIcoA = jq(treeTwo.$n()).find(".z-treerow:contains(A0)").toWidget().$n("icon");
        var treeTwoIcoB = jq(treeTwo.$n()).find(".z-treerow:contains(B1)").toWidget().$n("icon");

        click(treeOneIcoA); waitResponse();
        verifyTrue("A0-1 of Tree 1 should already opened",
            jq(jq(treeOne).find(".z-treerow:contains(A0-1)").toWidget().$n("icon")).hasClass("z-tree-open"));
        click(treeOneIcoB); waitResponse();
        verifyTrue("B1-1 of Tree 1 should already selected",
            jq(treeOne.$n()).find(".z-treerow.z-treerow-selected:contains(B1-1)").get(0).exists());

        click(btnOne); waitResponse();
        click(treeTwoIcoA); waitResponse();
        verifyTrue("A0-1 of Tree 2 should already opened",
            jq(jq(treeTwo.$n()).find(".z-treerow:contains(A0-1)").toWidget().$n("icon")).hasClass("z-tree-open"));
        click(btnTwo); waitResponse();
        click(treeTwoIcoB); waitResponse();
        verifyTrue("B1-1 of Tree 2 should already selected",
            jq(treeTwo.$n()).find(".z-treerow.z-treerow-selected:contains(B1-1)").get(0).exists());
    }
   );
  }
}
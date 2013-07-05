/* B60_ZK_707_TreeModelTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 11:20:09 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
 * A test class for bug ZK-707-TreeModel
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-707-TreeModel.zul,A,E,TreeModel,TreeSelectableModel,TreeOpenableModel,Tree,ROD")
class B60_ZK_707_TreeModelTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<window title="Test share TreeModel" border="normal">
			<zscript><![CDATA[
			ListModelList lm = new ListModelList(Arrays.asList(new String[]{"David", "Thomas","Steven"}));
					stm = new DefaultTreeModel(new DefaultTreeNode("ROOT",
							new DefaultTreeNode[]{
									new DefaultTreeNode("David"), 
									new DefaultTreeNode("Thomas"),
									new DefaultTreeNode("Steven")}));
					
					
					ArrayList list = new ArrayList();
					ArrayList list2 = new ArrayList();
					int len = 10;
					for(int i = 0; i < len; i++) {
						list.add("item " + i);
						list2.add(new DefaultTreeNode("item " + i));
					}
					ListModelList lm2 = new ListModelList(list);
					
					stm2 = new DefaultTreeModel(
							new DefaultTreeNode("ROOT", 
									Arrays.asList(new DefaultTreeNode[]{new DefaultTreeNode("root",list2)})));
			]]></zscript>
			Please test to open/close/select the treeitem, the both tree should be the same result.
			<tree id="treeOne" model="${stm2}" mold="paging" pageSize="3" onSelect="">
			<template name="model">
			<treeitem label="${each.data}"/>
			</template>
			</tree>
			<tree id="treeTwo" model="${stm2}" onSelect="">
			<template name="model">
			<treeitem label="${each.data}"/>
			</template>
			</tree>
			</window>

    """

   runZTL(zscript,
        () => {
        var treeOne: Widget = engine.$f("treeOne");
        var treeTwo: Widget = engine.$f("treeTwo");

        click(jq(treeOne).find(".z-treerow").toWidget().$n("icon"));
        waitResponse();
        verifyTrue("First tree should opened",
            jq(treeOne).find(".z-treerow").toWidget().$n("icon").exists());
        verifyTrue("Second Tree should opened as first tree",
            jq(treeTwo).find(".z-treerow").toWidget().$n("icon").exists());

        click(jq(treeTwo).find(".z-treerow").toWidget().$n("icon"));
        waitResponse();
        verifyTrue("Second tree should closed",
            jq(treeTwo).find(".z-treerow").toWidget().$n("icon").exists());
        verifyTrue("First Tree should closed as second tree",
            jq(treeOne).find(".z-treerow").toWidget().$n("icon").exists());
    }
   );
  }
}
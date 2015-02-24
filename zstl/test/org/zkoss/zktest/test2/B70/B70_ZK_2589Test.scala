package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2589.zul")
class B70_ZK_2589Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2589.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jan 26, 2015  4:44:37 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>

<zscript><![CDATA[
import org.zkoss.zktest.test2.B70_ZK_2589HierarchyTreeModel;

TreeModel model = new B70_ZK_2589HierarchyTreeModel("test");
model.setMultiple(true);
]]></zscript>

	<label multiline="true">
	1. scroll down slightly
	2. open one of these nodes 
	3. close it again
	4. scroll down to the bottom
	5. you should see all nodes rendered properly
	</label>
	<tree model="${model}" height="300px" checkmark="true" width="350px">
		<treecols>
			<treecol label="col 1"/>
			<treecol label="col 2"/>
		</treecols>
		<template name="model">
			<treeitem>
				<treerow>
					<treecell>
						<label value="${each.data}" />
					</treecell>
					<treecell>
						<label value="${each.data}" />
					</treecell>
				</treerow>
			</treeitem>
		</template>
	</tree>

</zk>
    
"""  
  runZTL(zscript,
    () => {
      var tree = jq("@tree");
      verScroll(tree, 0.1);
      
      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      verScroll(tree, 0.9);
      sleep(1000);
      verScroll(tree, 1);
      sleep(1000);
      verifyTrue(jq(".z-treerow").last().isVisible());
      verifyTrue(jq(".z-treerow").last().find(".z-label").eq(0).text() == "test-60");
    })
    
  }
}
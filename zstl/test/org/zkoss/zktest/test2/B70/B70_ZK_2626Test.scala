package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2626.zul")
class B70_ZK_2626Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2626.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Feb 25, 2015  2:43:13 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	You should see each of the following Tree cell are the same height.
	<hlayout height="150px">
		<tree mold="paging" pageSize="1" vflex="1" hflex="1">
			<custom-attributes org.zkoss.zul.tree.autohidePaging="false"/>
			<treecols>
				<treecol label="Treecell 16px with paging and pageSize 1" />
			</treecols>
			<treechildren>
				<treeitem forEach="1,2,3,4">
					<treerow>
						<treecell label="Item ${each}" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
		<tree mold="paging" pagingPosition="bottom" autopaging="true" vflex="1" hflex="1">
			<custom-attributes org.zkoss.zul.tree.autohidePaging="false"/>
			<treecols>
				<treecol label="Treecell 16px with paging and pageSize 1 and autopaging" />
			</treecols>
			<treechildren>
				<treeitem forEach="1,2,3,4">
					<treerow>
						<treecell label="Item ${each}" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
	</hlayout>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var tree1 = jq(".z-tree-body .z-treecell-content").eq(0);
      var tree2 = jq(".z-tree-body.z-tree-autopaging .z-treecell-content").eq(0);
      verifyTolerant(16, tree1.height(), 2);
      verifyTolerant(16, tree2.height(), 2);
    })
    
  }
}
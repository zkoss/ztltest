package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2398.zul")
class B70_ZK_2398Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2398.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Aug 12, 2014  3:51:43 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. Click on tree column to sort.
	2. It is bug if not see sort icon on tree column.
	</label>
	<tree id="tree" rows="5">
		<treecols sizable="true">
			<treecol label="Name" sort="auto" />
			<treecol label="Description" sort="auto" />
		</treecols>
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
					<treecell label="Item 1 description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item 2" />
					<treecell label="Item 2 description" />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 2.1" />
						</treerow>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 2.2" />
							<treecell
								label="Item 2.2 is something who cares" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
		</treechildren>
		<treefoot>
			<treefooter label="Count" />
			<treefooter label="Summary" />
		</treefoot>
	</tree>
</zk>

"""
    runZTL(zscript,
      () => {
        var clickTarget = jq("@treecol").eq(0);
        if (!isSafari)
          click(clickTarget);
        else
          clickAt(clickTarget, "2,2")

        waitResponse();
        verifyTrue("we should see the caret-up icon.", jq(".z-icon-caret-up").exists());
        if (!isSafari)
          click(clickTarget);
        else
          clickAt(clickTarget, "2,2")
        waitResponse();

        clickTarget = jq("@treecol").eq(1);
        if (!isSafari)
          click(clickTarget);
        else
          clickAt(clickTarget, "2,2")
        waitResponse();
        verifyTrue("we should see the caret-up icon.", jq(".z-icon-caret-up").exists());
      })

  }
}
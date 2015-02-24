package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2588.zul")
class B70_ZK_2588Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2588.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jan 26, 2015  4:01:15 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
 <label multiline="true">
   1. check 1st item
   2. check last item
   3. uncheck last item
   4. shouldn't scroll back to 1st item
  </label>
  		<tree height="300px" checkmark="true" multiple="true">
  			<treechildren>
	            <treeitem label="John" />
				<treeitem label="MALE" />
				<treeitem label="20" />
				<treeitem label="A college student." />
				<treeitem label="John" />
				<treeitem label="MALE" />
				<treeitem label="20" />
				<treeitem label="A college student." />
				<treeitem label="John" />
				<treeitem label="MALE" />
				<treeitem label="20" />
				<treeitem label="A college student." />
				<treeitem label="Mary" />
				<treeitem label="FEMALE" />
				<treeitem label="18" />
				<treeitem label="A young lady." />
				<treeitem label="Mary" />
				<treeitem label="FEMALE" />
				<treeitem label="18" />
				<treeitem label="A young lady." />
	        </treechildren>
  		</tree>
  		
		<listbox height="300px" checkmark="true" multiple="true">
			<listitem label="John" />
			<listitem label="MALE" />
			<listitem label="20" />
			<listitem label="A college student." />
			<listitem label="John" />
			<listitem label="MALE" />
			<listitem label="20" />
			<listitem label="A college student." />
			<listitem label="John" />
			<listitem label="MALE" />
			<listitem label="20" />
			<listitem label="A college student." />
			<listitem label="Mary" />
			<listitem label="FEMALE" />
			<listitem label="18" />
			<listitem label="A young lady." />
			<listitem label="Mary" />
			<listitem label="FEMALE" />
			<listitem label="18" />
			<listitem label="A young lady." />
			<listitem label="Mary" />
			<listitem label="FEMALE" />
			<listitem label="18" />
			<listitem label="A young lady." />
		</listbox>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var treecells = jq(".z-treecell");
      click(treecells.eq(0));
      waitResponse();
      click(treecells.last());
      waitResponse();
      var before = getScrollTop(jq("@tree").toWidget());
      click(treecells.last());
      waitResponse();
      verifyTrue(getScrollTop(jq("@tree").toWidget()) == before);
      
      var listcells = jq(".z-listcell");
      click(listcells.eq(0));
      waitResponse();
      click(listcells.last());
      waitResponse();
      before = getScrollTop(jq("@listbox").toWidget());
      click(listcells.last());
      waitResponse();
      verifyTrue(getScrollTop(jq("@listbox").toWidget()) == before);
    })
    
  }
}
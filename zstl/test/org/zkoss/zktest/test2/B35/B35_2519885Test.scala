/* B35_2519885Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 15, 2012 10:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2519885.zul,B,E,Window,Button")
class B35_2519885Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <zk>
        1. Check two or three rows on first page.
        <separator/>
        2. Click the next button to go to the next page.
        <separator/>
        3. Check one row (you must check on the checkbox, not on the row), and then click the previous button to go back to first page.
        <separator/>
        4. You should see the first step checking some rows should be remained.
        <zscript>
          <![CDATA[
          import org.zkoss.zktest.test2.tree.BinaryTreeModel;
	
	BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
]]>
        </zscript>
        <tree id="tree" mold="paging" pageSize="15" model="&#36;{btm}" checkmark="true" multiple="true">
          <attribute name="onCreate">
            <![CDATA[
		tree.renderItemByPath(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
		tree.renderItemByPath(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
]]>
          </attribute>
        </tree>
      </zk>
    """
    runZTL(zscript, () => {
      // Verify that there isn't a selected node
      verifyTrue("It should not be a selected nodes", jq(".z-treerow-selected").length() == 0);

      // Click on three nodes
      click(jq(".z-treerow").get(2));
      click(jq(".z-treerow").get(4));
      click(jq(".z-treerow").get(6));
      waitResponse();

      // Verify that there are three selected nodes
      verifyTrue("It should be three selected nodes", jq(".z-treerow-selected").length() == 3);

      // Click on next page button
      click(jq("[name=" + jq("@paging").attr("id") + "-next]"));
      waitResponse();

      // Click on one more row
      click(jq(".z-treerow").get(1));
      waitResponse();

      // Click on previous page button
      click(jq("[name=" + jq("@paging").attr("id") + "-prev]"));
      waitResponse();

      // Verify again that there are three selected nodes
      verifyTrue("It should be three selected nodes", jq(".z-treerow-selected").length() == 3);

      // Click on next page button
      click(jq("[name=" + jq("@paging").attr("id") + "-next]"));
      waitResponse();

      // Verify again that there is on selected node
      verifyTrue("It should be one selected node on this page", jq(".z-treerow-selected").length() == 1);


    })
  }
}
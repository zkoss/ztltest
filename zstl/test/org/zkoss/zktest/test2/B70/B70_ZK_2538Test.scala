package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2538.zul")
class B70_ZK_2538Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2538.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Jan 20, 2015 11:24:48 AM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
		1. Open the page
		2. Mavigate to the last page
		3. Click the "Simulate content changed" button in the first row"
		There should not be any JS error shown
	</label>
    <zscript><![CDATA[
    List items = Collections.nCopies(50000, "test");
    ]]></zscript>
    <tree mold="paging" pageSize="2">
        <treecols>
            <treecol label="Column 1" />
            <treecol label="Column 2" />
        </treecols>
        <treechildren>
            <treeitem forEach="${items}">
                <treerow>
                    <treecell label="${forEachStatus.index}"/>
                    <treecell>
                        <button label="Simulate content changed (detach)">
	                        <attribute name="onClick"><![CDATA[
	                        Treerow row = (Treerow) self.parent.parent;
	                        Treeitem item = row.getParent();
	                        row.detach();
	                        item.appendChild(row);
                        ]]></attribute>
                        </button>
                    </treecell>
                </treerow>
            </treeitem>
        </treechildren>
    </tree>
</zk>

    
"""
    runZTL(zscript,
      () => {
        var last_btn = jq(".z-paging-button.z-paging-last");
        click(last_btn);
        waitResponse();
        var row1 = jq(".z-button").eq(0);
        click(row1);
        var errbox = jq(".z-error");
        verifyTrue(!errbox.isVisible());
      })

  }
}
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2779.zul")
class B70_ZK_2779Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2779.zul

  Purpose:

  Description:

  History:
    Mon Jun 15 14:37:28 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
    <window border="normal" title="hello" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2779_ViewModel')" height="500px">
        <label multiline="true">
        1. Please uncheck the first treeitem. And you should see "selection count after unchecked is 22"
        2. Please uncheck the second treeitem. And you should see "selection count after unchecked is 11"
        3. Please uncheck the third treeitem. And you should see "selection count after unchecked is 0"
        4. Please check the third treeitem. And you should see "selection count after unchecked is 11"
        5. Open the thrid treeitem, all of its children should be selected.
        </label>
        <tree id="auditTree" model="@load(vm.treeModel)" checkmark="true" multiple="true"  vflex="1" onSelect="@command('treeSelect')" >
            <treecols>
                <treecol label=""/>
            </treecols>
            <template name="model">
                <treeitem  checkable="true" >
                    <treerow>
                        <treecell label="@bind(each.data.name)" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" />
                    </treerow>
                </treeitem>
            </template>
        </tree>
    </window>
</zk>
"""
    runZTL(zscript,
      () => {
        val msg_1 = "selection count after unchecked is 22"
        val msg_2 = msg_1 + "\nselection count after unchecked is 11"
        val msg_3 = msg_2 + "\nselection count after unchecked is 0"
        val msg_4 = msg_3 + "\nselection count after unchecked is 11"
        click(jq(".z-treerow-checkbox:eq(0)"))
        waitResponse()
        verifyEquals(msg_1, getZKLog())
        click(jq(".z-treerow-checkbox:eq(1)"))
        waitResponse()
        verifyEquals(msg_2, getZKLog())
        click(jq(".z-treerow-checkbox:eq(2)"))
        waitResponse()
        verifyEquals(msg_3, getZKLog())
        click(jq(".z-treerow-checkbox:eq(2)"))
        waitResponse()
        verifyEquals(msg_4, getZKLog())
      })
  }
}
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2880.zul")
class B80_ZK_2880Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2880.zul

	Purpose:
		
	Description:
		
	History:
		Fri Sep 18 11:34:57 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk>
    <window viewModel="@id('vm') @init('org.zkoss.zktest.test2.B80_ZK_2880ViewModel')">
        <vbox>
            <button label="Direct Click me, you should not see the new item added outside the combobox"
                    onClick="@command('buttonClick')"/>

            <combobox model="@load(vm.list)">
                <template name="model">
                    <comboitem value="@bind(each)" label="@bind(each.name)"/>
                </template>
            </combobox>
        </vbox>
    </window>
</zk>

"""
    runZTL(zscript,
      () => {
        //click the button
        click(jq("button"))
        waitResponse()
        //check there are no comboitems outside combobox
        //selector: select all comboitems that are NOT direct child of z-combobox-content (the combobox popup)
        verifyFalse(jq(".z-comboitem:not(.z-combobox-content > .z-comboitem)").exists())
      })
  }
}
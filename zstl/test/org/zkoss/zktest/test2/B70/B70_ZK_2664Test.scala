package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2664.zul")
class B70_ZK_2664Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2664.zul

	Purpose:
		
	Description:
		
	History:
		Tue Jul 7 14:30:29 CST 2015, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window border="normal" title="hello" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2664')">
		<label multiline="true">
			1. click the "Remove" Button next to "item 2"
			2. you should not see "item 1" focus
		</label>
		<grid model="@bind(vm.model)">
			<columns>
				<column label="Header" />
			</columns>
			<template name="model">
				<row>
					<hbox >
						<textbox inplace="true" value="@bind(each)" />
						<button onClick="@command('remove',item = each)" label="Remove" />
					</hbox>
				</row>
			</template>
		</grid>
	</window>
</zk>

    
"""  
  runZTL(zscript,
    () => {
      click(jq("button").eq(1)) //click second button
      waitResponse()
      verifyFalse(jq("input").eq(0).is(":focus")) //check the first input widget should NOT have focus
    })
  }
}
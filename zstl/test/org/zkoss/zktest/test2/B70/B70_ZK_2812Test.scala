package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2812.zul")
class B70_ZK_2812Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2812.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 13, 2015  12:10:34 PM, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2812_VM')">
		<label multiline="true">
			1. open/close each group in grid
			2. you should see notifications
		</label>
		<grid model="@load(vm.groupmodel)">
			<columns>
				<column label="Cols" />
			</columns>
			<template name="model:group">
				<group label="${each}" onOpen="@command('open')"/>
			</template>
			<template name="model">
				<row>
					<label value="${each}" />
				</row>
			</template>
		</grid>
	</window>
</zk>

"""  
  runZTL(zscript,
    () => {
      //make sure no notification is present at init
      verifyFalse(jq(".z-notification").exists());
      //click to open group 1
      click(jq(".z-group-icon").eq(0))
      waitResponse()
      //check notification appears
      verifyTrue(jq(".z-notification").exists());
      //click to close group 1
      click(jq(".z-group-icon").eq(0))
      waitResponse()
      //check notification appears
      verifyTrue(jq(".z-notification").exists());
      //click to open group 2
      click(jq(".z-group-icon").eq(1))
      waitResponse()
      //check notification appears
      verifyTrue(jq(".z-notification").exists());
      //click to close group 2
      click(jq(".z-group-icon").eq(1))
      waitResponse()
      //check notification appears
      verifyTrue(jq(".z-notification").exists());
    })
  }
}
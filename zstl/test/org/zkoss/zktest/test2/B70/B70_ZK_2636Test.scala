package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2636.zul")
class B70_ZK_2636Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2636.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Feb 25, 2015  3:50:42 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<div apply="org.zkoss.bind.BindComposer"
	viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2636VM')"
	validationMessages="@id('vmsgs')"
	form="@id('fx') @load(vm.bean) @save(vm.bean, before='save') @validator(vm.beanValidator, prefix='p_')">
	Please selected an item and click two buttons "Show" and "Save", you should see "null" in the console.
	<combobox id="cbx" model="@load(vm.letters)" selectedItem="@bind(fx.letter)"
		errorMessage="@load(vmsgs['p_letter'])"
		onChange="@command('onChangeLetter')">
		<template name="model">
			<comboitem label="${each}" />
		</template>
	</combobox>
	<button onClick='Clients.log("" + (cbx.getSelectedItem() != null?cbx.getSelectedItem().getLabel() : "null"))' label="Show"/>
	<button onClick="@command('save')">Save</button>
</div>
    
"""  
  runZTL(zscript,
    () => {
      var show = jq("@button").eq(0);
      var save = jq("@button").eq(1);
      click(jq(".z-combobox-button"));
      waitResponse();
      click(jq(".z-combobox-popup ul li"));
      waitResponse();
      click(show);
      waitResponse();
      click(save);
      sleep(1000);
      verifyEquals("a\nValidate value: a", jq("#zk_log").eval("val()").trim());
    })
    
  }
}
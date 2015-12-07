package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2832.zul")
class B70_ZK_2832Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2832.zul

	Purpose:
		
	Description:
		
	History:
		Fri Jul 31 12:04:29 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
    <label multiline="true">
        1. Please open "Test Selection issue"
        2. Please select "Child 1", it should be selected.
        2. Please select "Child 2", if it cannot be selected that's a bug.
    </label>
<navbar id="navbar" orient="vertical" collapsed="false"
        onSelect="self.getSelectedItem().invalidate()">

    <nav label="Test Selection issue" iconSclass="z-icon-home">
        <navitem label="Child 1"/>
        <navitem label="Child 2"/>
        <navitem label="Child 3"/>
        <navitem label="Child 4"/>
        <navitem label="Child 5"/>
    </nav>
</navbar>
</zk>

"""  
  runZTL(zscript,
    () => {
      //expand the navbar
      click(jq(".z-nav-content"))
      waitResponse()
      //click the 1st item
      click(jq(".z-navitem-content").eq(0))
      waitResponse()
      //check 1st item is selected
      verifyTrue(jq(".z-navitem").eq(0).hasClass("z-navitem-selected"))
      //click the 2nd item
      click(jq(".z-navitem-content").eq(1))
      waitResponse()
      //check 2nd item is selected
      verifyTrue(jq(".z-navitem").eq(1).hasClass("z-navitem-selected"))
    })
  }
}
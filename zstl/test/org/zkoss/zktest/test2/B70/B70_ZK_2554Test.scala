package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2554.zul")
class B70_ZK_2554Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2554.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jan 30, 2015  2:13:19 PM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
    <label multiline="true">
    1. Right click on textbox to open context menu.
    2. The context menu is closed when tooltip showed.
    This does not happen in ZK 6.5.x
    </label>
    <textbox rows="3" width="250px" context="editPopup" tooltip="tooltip" />
    <popup id="editPopup" width="300px" height="100px">
        Context Menu
    </popup>
    <popup id="tooltip" width="100px">
        Tooltip Menu
    </popup>
</zk>

    
"""
    runZTL(zscript,
      () => {
        var textbox = jq("@textbox");
        contextMenu(textbox);
        waitResponse();
        mouseOver(textbox);
        waitResponse();

        verifyTrue(jq(".z-popup").exists());
      })

  }
}
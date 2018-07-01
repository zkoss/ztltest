package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2775.zul")
class B70_ZK_2775Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2775.zul

	Purpose:

	Description:

	History:
		Mon Jun  8 14:32:19 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:w="client">
 <label multiline="true">
 1. open this page
 2. you should see popup is open without loading mask
 </label>
 <div id="d1" height="100%"  popup="pop" onCreate='pop.open(self, "middle_center")'>
  <popup id="pop" onOpen='Clients.showNotification("onOpen")'>
   <div width="200px" height="200px">
    Popup Content
   </div>
  </popup>
 </div>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyFalse(jq(".z-apply-mask").exists())
      })

  }
}
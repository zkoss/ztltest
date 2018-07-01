package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-1683.zul")
class B70_ZK_1683Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-1683.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 24, 2013 12:35:01 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<div style="color: red;">
	1. You should not see an endless loop for the alert message.
	<separator/>
	2. Unless you close the alert window, it will show the next error.
	</div>
<zscript><![CDATA[
List list = new ArrayList();
list.add("one");
list.add("two");

ListModelList model = new ListModelList(list);
]]></zscript>
<grid model='${model}'>
<columns>
<column>wrongProperty</column>
</columns>
<template name="model">
<row>${each.wrongProperty}
</row>
</template>
</grid>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyTrue("You should not see an endless loop for the alert message.", jq(".z-window-modal").length() == 1)
        click(jq(".z-window-close"))
        waitResponse()
        verifyTrue("You should not see an endless loop for the alert message.", jq(".z-window-modal").length() == 1)
      })

  }
}
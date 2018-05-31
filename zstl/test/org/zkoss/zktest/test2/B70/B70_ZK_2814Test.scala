package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2814.zul")
class B70_ZK_2814Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2814.zul

	Purpose:
		
	Description:
		
	History:
		Tue Jul 14 14:49:37 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click each buttons
	2. you should not see any js error
	</label>
	<zscript><![CDATA[
   		void scrollDetached() {
   			Clients.scrollIntoView(tb);
   			tb.detach();
   		}
    ]]></zscript>
	<textbox id="tb" />
	<button onClick="scrollDetached()">scroll detach</button>
	<button onClick="Clients.scrollIntoView(null)">scroll null</button>
</zk>

"""
    runZTL(zscript,
      () => {
        click(jq("button").eq(0))
        waitResponse()
        click(jq("button").eq(1))
        waitResponse()
        verifyFalse(hasError());
      })
  }
}
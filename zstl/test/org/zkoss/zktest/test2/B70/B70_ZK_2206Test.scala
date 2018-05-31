package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2206.zul")
class B70_ZK_2206Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2206.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Mar 31, 2014  5:26:21 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<zscript>
Treechildren tc = new Treechildren();
tc.setId("abc");
</zscript>
You should not see any java exception and then 

<button label="Click this to see the log with a word 'true'">
<attribute name="onClick">
tree.appendChild(tc);
Clients.evalJavaScript("zk.log(zk.Widget.$('$abc') != null)");
</attribute>
</button>
<tree id="tree"/>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyFalse("no exception", jq(".z-window-modal").exists())
        click(jq(".z-button"))
        waitResponse()
        sleep(200) // wait for the log to show up
        verifyTrue("the log with a word 'true'", jq("#zk_log").`val`().trim() == "true")
      })

  }
}
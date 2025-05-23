package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1905.zul")
class B65_ZK_1905Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1905.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Aug 30, 2013  9:53:41 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript>
	List lst = Arrays.asList(new String[] { "first", "second", "third" });
	ListModel model = new ListModelList(lst);
	</zscript>
		<label multiline="true">
		1. Focus into the chosenbox the "--------" text should be removed.
		2. Focus out of the chosenbox the "-------" text should appear again.
		3. Focus in and select an item in the dropdown list.
		4. Remove that item you selected by clicking the close icon, and the "-------" text should not appear there (when focused)
		</label>
		<chosenbox id="cbx" width="500px" model="${model}" emptyMessage="------------------"/>
</zk>"""
    runZTL(zscript,
      () => {
        val inp = jq(".z-chosenbox").toWidget().$n("inp")
        click(inp)
        waitResponse()
        verifyNotContains("the '--------' text should be removed", inp.attr("value"), "-")
        blur(inp)
        waitResponse()
        verifyContains("the '--------' text should appear again", inp.attr("value"), "-")
        click(inp)
        waitResponse()
        click(jq(".z-chosenbox-option:eq(0)"))
        waitResponse()
        click(jq(".z-chosenbox-delete"))
        waitResponse()
        verifyNotContains("the '--------' text should not appear", inp.attr("value"), "-")
      })

  }
}
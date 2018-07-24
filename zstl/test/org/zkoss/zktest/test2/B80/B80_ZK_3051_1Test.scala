package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3051-1.zul")
class B80_ZK_3051_1Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    // have to use zscript to solve the src path issue
    val zscript =
      """
      <?xml version="1.0" encoding="UTF-8"?>
<!--
B80-ZK-3051-1.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Dec 30, 2015  3:14:55 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
When a combobox popup is to tall to be opened bellow the combobox, it is opened from the top of the current frame instead.
If the combobox text-input is in the middle of the page, it can be covered by the drop down popup menu, which makes typing difficult.

click the combobox, if the bottom space is not enouth to show popup, the popup will try to show on top of text-input;
if the top space is not enouth either, the popup will force show on the bottom of text-input.
</label>
<iframe width="250px" height="200px" src="test2/B80-ZK-3051-2.zul">
</iframe>
</zk>
    """
    runZTL(zscript,
      () => {
        // jq cannot interact with elements inside iframe, have to execute native js
        getEval("jq(\"iframe\").contents().find(\".z-combobox-button\")[0].click()")
        waitResponse()
        val h = getEval("jq(\"iframe\").contents().find(\".z-combobox\").outerHeight()")
        val top = getEval("jq(\"iframe\").contents().find(\".z-combobox-popup\").position().top")
        verifyEquals(h, top)
      })
  }
}

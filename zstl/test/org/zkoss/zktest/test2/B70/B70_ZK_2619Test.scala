package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2619.zul")
class B70_ZK_2619Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2619.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Mar 03, 2015 11:00:06 AM, Created by JamesChu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click two buttons separately
	2. both errorbox will show up
	</label>
	<button label="Wrong value" onClick='throw new WrongValueException(textbox1, "error message");'/>
	<textbox id="textbox1" multiline="true"/>
    <hlayout>
	    <button label="Wrong value" onClick='throw new WrongValueException(textbox2, "error message");'/>
	    <textbox id="textbox2" multiline="true"/>
	</hlayout>
</zk>
    
"""
    runZTL(zscript,
      () => {
        var btn = jq("@button");
        click(btn.eq(0));
        waitResponse();
        click(btn.eq(1));
        sleep(1000);
        verifyEquals(2, jq(".z-errorbox.z-errorbox-open").length());
      })

  }
}
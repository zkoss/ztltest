package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2293.zul")
class B70_ZK_2293Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2293.zul

	Purpose:
		
	Description:
		
	History:
		Tue, May 13, 2014 12:26:22 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<vlayout>
Please open the bandpopup twice, the width of the popup should be the same.
<bandbox hflex="1">
    <bandpopup>
        <hlayout>
            <label value="Name" hflex="1" />
            <space />
            <label value="Surname" hflex="1" />
        </hlayout>
        <hlayout>
            <textbox value="Peter" hflex="1" />
            <space />
            <textbox value="Parker" hflex="1" />
        </hlayout>
    </bandpopup>
</bandbox>
</vlayout>
</zk>
"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-bandbox-button");
      
      click(btn);
      waitResponse()
      val w1 = jq(".z-bandbox-popup").width();
      click(btn);
      waitResponse()
      
      click(btn);
      waitResponse()
      val w2 = jq(".z-bandbox-popup").width();
      click(btn);
      waitResponse()
            
      verifyTrue("the width of popup in two times should be the same.", w1 == w2);
    })
    
  }
}
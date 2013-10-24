package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F65-ZK-1825.zul")
class F65_ZK_1825Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
F70-ZK-1825.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 24, 2013 11:13:08 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	1. Please select a date in the datebox.
	<separator/>
	2. Change the time in the timebox.
	<separator/>
	3. Click the "show timebox value", the result should be the value of datebox + timebox.	It shouldn't be reset to today.
	<datebox onChange="tb.value = self.value;"/>
	<timebox id="tb"/>
	<button label="show timebox value" onClick="alert(tb.value);"/>
</zk>
"""
    runZTL(zscript,
      () => {
        val db = jq(".z-datebox").toWidget()
        val tb = jq(".z-timebox").toWidget()
        click(db.$n("btn"))
        waitResponse()
        
        val calendar0 = jq(".z-calendar:eq(0)")
        click(calendar0.find(".z-calendar-title .z-calendar-ctrler:eq(1)"))
        waitResponse()
        click(calendar0.find(".z-calendar-calyear td:contains(2013)"))
        waitResponse()
        click(calendar0.find(".z-calendar-calmon td:eq(9)"))
        waitResponse()
        click(calendar0.find(".z-calendar-calday td:contains(20)"))
        waitResponse()
        click(jq(".z-button"))
        waitResponse()

        verifyTrue("It shouldn't be reset to today", 
            jq(".z-messagebox-window .z-label:contains(Sun Oct 20)").exists)
      })

  }
}
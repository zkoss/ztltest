package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.junit.Test
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F65-ZK-1973.zul")
class F65_ZK_1973Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
F65-ZK-1973.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Oct 16, 2013  3:46:34 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<script>
zk.afterMount(function () { if (!zk.processMask) {
zk.processMask = true;
}})
</script>
<label multiline="true">
1. Please click the test button (the library property of the org.zkoss.zk.ui.processMask.enabled should be set in zk.xml)
2. You should see the process is algined to center with a mask.
</label>
<button label="test">
<attribute name="onClick">
Thread.sleep(3000);
</attribute>
</button>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyImage()
    })
    
  }
}
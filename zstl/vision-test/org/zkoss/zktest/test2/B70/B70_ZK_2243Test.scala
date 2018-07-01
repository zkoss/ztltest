package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2243.zul")
class B70_ZK_2243Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2243.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Apr 03, 2014 10:42:23 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please resize to expend the width of the window component
<separator/>
2. Please resize to shrink the width of the window component
<separator/>
3. You should see the second Listbox should be shrunk as well.
<window title="Resize Issue Test Window" border="normal" width="200px" sizable="true">
<vbox width="100%" hflex="1">

<vbox width="100%" hflex="1">
<listbox width="100%" hflex="1">
<listhead>
<listheader label="Resizes"/>
<listheader label="Properly"/>
</listhead>
<listitem>
<listcell label="Test Cell"/>
<listcell label="Test Cell"/>
</listitem>
</listbox>
</vbox>

<tablelayout width="100%" hflex="1">
<tablechildren width="100%">
<listbox width="100%" hflex="1">
<listhead>
<listheader label="Grows but"/>
<listheader label="Doesn't shrink"/>
</listhead>
<listitem>
<listcell label="Test Cell"/>
<listcell label="Test Cell"/>
</listitem>
</listbox>
</tablechildren>
</tablelayout>

</vbox>
</window>
</zk>
"""
    runZTL(zscript,
      () => {
        val win = jq(".z-window")
        dragdropTo(win, "200,2", "400,2")
        waitResponse()
        dragdropTo(win, "400,2", "300,2")
        waitResponse()
        verifyImage()
      })

  }
}
package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1854.zul")
class B65_ZK_1854Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1854.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 29, 2013  5:05:31 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
If the "Processing..." is never closed, that's a bug.
<window id="win" title="Window" border="normal" width="600px">
<toolbar mold="panel" align="center" vflex="1" hflex="1">
<toolbarbutton label="Left"/>
</toolbar>
</window>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyTrue(!jq(".z-loading").exists())
      })

  }
}
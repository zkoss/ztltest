package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1813.zul")
class F70_ZK_1813Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
F70-ZK-1813.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Jun 13, 2013  4:57:56 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	You should see the button left contains a user icon.
<button label="Button" mold="trendy" iconSclass="z-icon-user" />
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2275.zul")
class B70_ZK_2275Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2275.zul

	Purpose:
		
	Description:
		
	History:
		Thu, May 08, 2014  4:39:17 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
You should not see any JS error
<button hflex="min" image="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEUAAAALAAAAAABAAEAAAICRAEAOw=="/>
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq("@button"));
        waitResponse();
        verifyFalse(jq(".z-error").exists());
      })

  }
}
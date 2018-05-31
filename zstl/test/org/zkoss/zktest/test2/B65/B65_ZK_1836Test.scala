package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1836.zul")
class B65_ZK_1836Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1836.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 03, 2013 10:03:35 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk xmlns:n="native" xmlns:h="xhtml">
  If you can see the log with "&lt;/script>" three times, the bug is fixed.
  <script>
    var s = "&lt;/Script>";
    zk.log(s);
    </script>
  <n:script>
    var s = "&lt;/ScripT>";
    zk.log(s);
    </n:script>
  <h:script>
    var s = "&lt;/ScrIpt>";
    zk.log(s);
    </h:script>
</zk>
"""
    runZTL(zscript,
      () => {

        sleep(500);
        val v = jq("#zk_log").`val`()
        verifyTrue("If you can see the log with '</script>' three times, the bug is fixed.",
          v.contains("</Script>") && v.contains("</ScripT>") && v.contains("</ScrIpt>"))
      })

  }
}
package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1956.zul")
class F70_ZK_1956Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>
<zk>
<zscript><![CDATA[
org.zkoss.lang.Library.setProperty("org.zkoss.zkmax.tablet.ui.disabled", "true");
]]></zscript>
	<label multiline="true">
	1. Open this zul with tablet device or set browser's user agent to "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10" and reload the page.
	2. Click the datebox icon, it will show calendar instead of time wheel.
	</label>
	<datebox/>
</zk>"""  
  runZTL(zscript,
    () => {
      val db = jq(".z-datebox").toWidget()
      singleTap(db.$n("btn"))
      waitResponse()
      verifyTrue("it will show calendar instead of time wheel.", jq(db.$n("pp")).find(".z-calendar-text").exists)
    })
    
  }
}
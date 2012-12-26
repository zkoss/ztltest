package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1227.zul")
class B60_ZK_1227Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    Should not see any error message.<separator/>
                    <decimalbox value="1111.112" locale="pt" format="#.##0,0##"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyTrue("should not see any error message.", !jq(".z-errbox").exists())
      })

  }
}

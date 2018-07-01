package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1431.zul")
class B65_ZK_1431Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <label multiline="true">
                      Should not see "processing..." message.
                    </label>
                    <include height="200px" src="/test2/B65-ZK-1431-1.zul" mode="defer"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyTrue(!jq(".z-loading").exists())
      })

  }
}

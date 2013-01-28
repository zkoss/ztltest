package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1516.zul")
class B65_ZK_1516Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        Should not see "processing..." bar.
        <hlayout>
          <textbox hflex="1" value="1"/>
          <textbox hflex="2" value="2"/>
          <timer/>
          <script/>
        </hlayout>
      </zk>"""

    runZTL(zscript,
      () => {
        verifyTrue(!jq(".z-loading").exists())
      })

  }
}

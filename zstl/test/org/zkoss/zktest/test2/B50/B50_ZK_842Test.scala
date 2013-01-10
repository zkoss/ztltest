package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B50-ZK-842.zul")
class B50_ZK_842Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <zscript>
                      Clients.reloadMessages(null);
                    </zscript>
                    <div>
                      Enter '00' in the Intbox below and click on somewhere else. You should see an error message. Otherwise it is a bug.
                    </div>
                    <intbox/>
                  </zk>"""

    runZTL(zscript,
      () => {
        val intbox = jq(".z-intbox")
        sendKeys(intbox, "00")
        waitResponse()
        blur(intbox)
        waitResponse()
        verifyTrue("should see an error message.", jq(".z-errbox").exists())
      })

  }
}

package org.zkoss.zktest.test2.theme

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class Thm_Panel_Misc_Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="Panel" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <panel title="panel" border="normal" width="300px" height="300px">
                      <panelchildren style="overflow:auto;">
                        <label style="white-space:nowrap" value="-------------------------------------------------------------------------------------------"/>
                      </panelchildren>
                    </panel>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}

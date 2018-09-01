package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-812.zul")
class B50_ZK_812Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      You should not see java error.
                      <window id="win" title="Window">
                        <label id="lb" value="Label"/>
                      </window>
                    </div>
                    <zscript>
                      Components.wireFellows(win, new Object());
                    </zscript>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyFalse("should not see java error.", jq(".z-window-modal").exists())
      })

  }
}

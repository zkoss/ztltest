package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1505.zul")
class B65_ZK_1505Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <label multiline="true">
                      Click "Access page" button, should see Progressing bar showed.
                    </label>
                    <div>
                      <button id="btn" label="Access page" onClick="Thread.sleep(10000L);"/>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button"))
        sleep(1000)
        verifyTrue(jq(".z-loading").exists())
      })

  }
}

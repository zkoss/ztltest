package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1589.zul")
class B60_ZK_1589Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk xmlns:n="native" xmlns:w="client">
        <window id="win" title="new page title" border="normal" width="100%" height="100%">
          <label multiline="true">
            1. Click "invalidate" button.
		2. If you did not see "unbind_ window" message, it is a bug.
          </label>
          <button id="btn" label="invalidate" onClick="cave.invalidate();"></button>
          <div id="cave">
            <n:div>
              <window title="window" border="normal">
                <attribute w:name="unbind_">
    					function () {
							zk.log('unbind_ window');
							this.$unbind_();
						}
                </attribute>
              </window>
            </n:div>
          </div>
        </window>
      </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(invalidate)"))
        waitResponse()
        verifyEquals("should see 'unbind_ window' message", jq("textarea").`val`().replaceAll("\n", ""), "unbind_ window")
      })

  }
}

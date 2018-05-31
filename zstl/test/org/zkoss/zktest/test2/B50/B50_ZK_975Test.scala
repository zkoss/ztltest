package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-975.zul")
class B50_ZK_975Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      The three textboxes should have almost the same width.
                    </div>
                    <div width="300px">
                      <textbox hflex="1" multiline="true" value="Textbox 1"/>
                    </div>
                    <div width="300px">
                      <textbox mold="rounded" hflex="1" multiline="true" value="Textbox 2"/>
                    </div>
                    <div width="300px">
                      <textbox mold="rounded" width="100%" multiline="true" value="Textbox 2"/>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        val width0 = jq(".z-textbox:eq(0)").width()
        val width1 = jq(".z-textbox:eq(1)").width()
        val width2 = jq(".z-textbox:eq(2)").width()

        verifyTolerant(width0, width1, 10)
        verifyTolerant(width0, width2, 10)
        verifyTolerant(width1, width2, 10)
      })

  }
}

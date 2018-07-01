package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-987.zul")
class B60_ZK_987Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).
                    </div>
                    <hlayout>
                      <groupbox mold="3d" height="200px" width="200px">
                        <caption label="Groupbox"/>
                        Groupbox
                      </groupbox>
                      <groupbox mold="3d" title="Groupbox" height="200px" width="200px">
                        Groupbox
                      </groupbox>
                    </hlayout>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).", jq(jq(".z-groupbox:eq(0)").toWidget().$n("header")).height(), jq(jq(".z-groupbox:eq(1)").toWidget().$n("header")).height())
      })
  }
}

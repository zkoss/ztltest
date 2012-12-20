package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-987.zul")
class B60_ZK_987Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
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
        
        
        verifyTrue("The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).",  jq(".z-groupbox-3d-header:eq(0)").is(":contains(Groupbox)"))
        verifyTrue("The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).",  jq(".z-groupbox-3d-header:eq(1)").is(":contains(Groupbox)"))
        verifyTrue("The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).",  jq(".z-groupbox-3d-cnt:eq(0)[style*=border-top-width:0px]").exists())
        verifyTrue("The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).",  jq(".z-groupbox-3d-cnt:eq(1)[style*=border-top-width:0px]").exists())
        
      })

  }
}

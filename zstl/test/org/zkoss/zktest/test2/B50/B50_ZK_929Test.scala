package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-929.zul")
class B50_ZK_929Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
                  <zk>
                    <label value='${c:replace("ZK-123-ZK-456-ZK", "ZK", "Hello ZK!")}'/>
                    <separator/>
                    (It should be [<label value='Hello ZK!-123-Hello ZK!-456-Hello ZK!'/>
                    ] )
                    <separator/>
                    <separator/>
                    <label value='${c:replace("ZKZKZK-456", "ZK", "ZKTest")}'/>
                    <separator/>
                    (It should be [<label value='ZKTestZKTestZKTest-456'/>
                    ] )
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("should be Hello ZK!-123-Hello ZK!-456-Hello ZK!", jq(".z-label:eq(0)").text(), "Hello ZK!-123-Hello ZK!-456-Hello ZK!")
        verifyEquals("should be ZKTestZKTestZKTest-456", jq(".z-label:eq(4)").text(), "ZKTestZKTestZKTest-456")
      })

  }
}

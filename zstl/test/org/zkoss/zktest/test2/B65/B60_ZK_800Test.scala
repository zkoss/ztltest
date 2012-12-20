package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-800.zul")
class B60_ZK_800Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk><vlayout>
                        <html>You shall see a hyper link below having a label (Link) and an image</html>
                        <a label="Link"><image src="/img/inet.png"/></a>
                      </vlayout></zk>"""

    runZTL(zscript,
      () => {
        verifyTrue(jq(".z-a:contains(Link)").exists())
        verifyTrue(jq(".z-image").parent().is("a"))
      })

  }
}

package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1829.zul")
class B70_ZK_1829Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window apply="org.zkoss.zktest.test2.B70_ZK_1829" width="300px" border="normal">
	Should not show any error message.
</window>"""  
  runZTL(zscript,
    () => {
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}
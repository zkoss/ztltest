package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2970.zul")
class B80_ZK_2970Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val inp = jq("@textbox").eq(0)
      clickAt(inp, "20,0")
      waitResponse(true)
      keyPressNative("65")
      waitResponse(true)
      verifyEquals("1A", inp.`val`())
    })
  }
}
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2881.zul")
class B80_ZK_2881Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
   <include src="/test2/B80-ZK-2881.zul"/>
  """
  runZTL(zscript,
    () => {
      waitResponse()
      var item = jq(".z-listitem:last")
      click(item)
      waitResponse()
      verifyTrue(item.hasClass("z-listitem-focus"))
      click(item)
      waitResponse()
      verifyTrue(item.hasClass("z-listitem-focus"))
    })
  }
}
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2783.zul")
class B70_ZK_2783Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
    <include src="/test2/B70-ZK-2783.zul"/>
  """
  runZTL(zscript,
    () => {
      //open to check items number
      val combobox = jq("@combobox").toWidget
      combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
      waitResponse()
      verifyEquals(20, jq("@comboitem:first").outerHeight())
    })
  }
}
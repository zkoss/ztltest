package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2783.zul")
class B70_ZK_2783Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //open to check items number
        val combobox = jq("@combobox").toWidget
        evalScript(combobox + ".open()") // to show popu first so we can find comboitem in zkmax
        waitResponse()
        verifyTolerant(26, jq("@comboitem:first").outerHeight(), 2)
      })
  }
}
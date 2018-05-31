package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1430.zul")
class B65_ZK_1430Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      click(jq(".z-bandbox").toWidget().$n("btn"))
      waitResponse()
      verifyTolerant(jq(".z-listbox-body").height(), jq(".z-listitem").height() * 5, 10)
    })

  }
}
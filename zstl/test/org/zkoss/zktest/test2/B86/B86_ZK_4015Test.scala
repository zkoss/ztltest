package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4015.zul")
class B86_ZK_4015Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()

      getEval("window.scroll(0, 10000)")
      click(jq("@bandbox:last").toWidget.$n("btn"))
      waitResponse()
      verifyEquals(1, jq("@bandpopup:visible").length)

      click(jq("@label:contains(*):last"))
      waitResponse()
      verifyEquals(0, jq("@bandpopup:visible").length)
    })
  }
}

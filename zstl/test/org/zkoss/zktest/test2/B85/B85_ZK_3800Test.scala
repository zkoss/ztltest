package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3800.zul")
class B85_ZK_3800Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      click(jq("$btnCheck"))
      waitResponse()

      verifyEquals("The height of buttons are not the same.", "true", jq("$result").html())
    })
  }
}

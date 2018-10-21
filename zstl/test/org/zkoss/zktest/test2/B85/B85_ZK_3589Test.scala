package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3589.zul")
class B85_ZK_3589Test extends ZTL4ScalaTestCase {
  @Test
  def testScrollOverViewport()=  {
    runZTL(() => {
      val lbl = jq("@label")
      val top = jq("$btnTop")
      val bottom = jq("$btnBottom")
      click(lbl)
      waitResponse()

      // To the bottom and click something
      evalScript(zk(bottom) + ".scrollIntoView()")
      waitResponse()
      click(bottom)
      waitResponse()

      // To the top
      evalScript(zk(top) + ".scrollIntoView()")
      waitResponse()
      verifyFalse("The popup still appears!", jq("@popup").isVisible)
    })
  }
}

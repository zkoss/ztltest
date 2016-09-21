package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenning on 5/30/16.
  */
class B80_ZK_3168Test extends ZTL4ScalaTestCase {

  @Test
  def test() =  {
    runZTL(
      () => {
        val chb = jq(".z-chosenbox").toWidget()
        click(chb)
        waitResponse(true)
        sendKeys(chb.$n("inp"), "I")
        waitResponse(true)
        click(jq(".z-chosenbox-option:visible").get(2))
        waitResponse(true)
        verifyEquals(1, jq(".z-chosenbox-item").length())
        verifyEquals(1, jq(".z-listcell-content").length())
        verifyEquals("Item1", jq(".z-listcell-content").text())
      }
    )
  }

}

package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1218.zul")
class B65_ZK_1218Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val doublebox = jq(".z-doublebox")
      val doublespinner = jq(".z-doublespinner-input")

      sendKeys(doublebox, "1")
      sendKeys(doublebox, ".")
      sendKeys(doublebox, "224323423452352345345345634534634634")

      blur(doublebox)
      waitResponse()
      verifyTrue(jq(".z-errorbox:eq(0)").exists())


      focus(doublespinner)
      sendKeys(doublespinner, "1")
      sendKeys(doublespinner, ".")
      sendKeys(doublespinner, "224323423452352345345345634534634634")

      blur(doublespinner)
      waitResponse()
      verifyTrue(jq(".z-errorbox:eq(1)").exists())
    })

  }
}

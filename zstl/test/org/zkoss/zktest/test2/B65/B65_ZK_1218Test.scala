package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B65-ZK-1218.zul")
class B65_ZK_1218Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <label multiline="true">
                      1. Type 1.224323423452352345345345634534634634 in the doublebox and doublespinner
    				2. Should see "Illegal value" message instead of "You must specify a number, rather than 'input'"
                    </label>
                    <doublebox width="300px"/><separator/>
                    <doublespinner width="300px"/>
                  </zk>

    runZTL(zscript,
      () => {
        val doublebox = jq(".z-doublebox")
        val doublespinner = jq(".z-doublespinner-inp")

        sendKeys(doublebox, "1")
        sendKeys(doublebox, Keys.DECIMAL)
        sendKeys(doublebox, "224323423452352345345345634534634634")

        blur(doublebox)
        waitResponse()
        verifyTrue(jq(".z-errbox:eq(0)").exists())
        

        focus(doublespinner)
        sendKeys(doublespinner, "1")
        sendKeys(doublespinner, Keys.DECIMAL)
        sendKeys(doublespinner, "224323423452352345345345634534634634")

        blur(doublespinner)
        waitResponse
        verifyTrue(jq(".z-errbox:eq(1)").exists())
      })

  }
}

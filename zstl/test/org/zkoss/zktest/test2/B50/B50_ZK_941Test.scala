package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B50-ZK-941.zul")
class B50_ZK_941Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns:h="xhtml">
                    <h:pre>
                      1. Enter 1.239 and blur, the error message will be shown at its right side
	2. Enter 1.0  and blur, it should clear the error message
	3. Repeat 1 and 2 for the second decimalbox, and the message will be a popup (error box).
                    </h:pre>
                    <div apply="org.zkoss.zktest.test2.B50_ZK_941_Composer">
                      <groupbox>
                        <caption label="custom constraint"/>
                        <vlayout>
                          <div> Message: <label id="label" style="color:red;"/> </div>
                          <div> decimal <decimalbox id="dec" format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                          <div> double <doublebox id="dbl" format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                        </vlayout>
                      </groupbox>
                    </div>
                    <groupbox>
                      <caption label="no custom constraint"/>
                      <vlayout>
                        <div> decimal <decimalbox format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                        <div> doublebox <doublebox format="#.##" width="150px" roundingMode="UNNECESSARY"/>			</div>
                      </vlayout>
                    </groupbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        val dec0 = jq(".z-decimalbox:eq(0)")
        sendKeys(dec0, "1.239")
        waitResponse()
        blur(dec0)
        waitResponse()
        verifyTrue("the error message will be shown at its right side", jq(".z-label[style*=red]").text().length() != 0)

        sendKeys(dec0, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "0")
        waitResponse()
        blur(dec0)
        waitResponse()
        verifyTrue("should clear the error message", jq(".z-label[style*=red]").text().length() == 0)

        val dec1 = jq(".z-decimalbox:eq(1)")
        sendKeys(dec1, "1.239")
        waitResponse()
        blur(dec1)
        waitResponse()
        verifyTrue("the error message will be shown at its right side", jq(".z-errbox").exists())

        sendKeys(dec1, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "0")
        waitResponse()
        blur(dec1)
        waitResponse()
        verifyTrue("should clear the error message", !jq(".z-errbox").exists())

      })

  }
}

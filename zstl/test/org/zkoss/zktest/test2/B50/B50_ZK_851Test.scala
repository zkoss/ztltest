package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-851.zul")
class B50_ZK_851Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk xmlns="http://www.zkoss.org/2005/zul" xmlns:n="http://www.zkoss.org/2005/zk/native">
                    <div>step 1: open Popup by click the first button</div>
                    <div>step 2: edit text of the textbox</div>
                    <div>step 3: close popup by clicking outside the popup area</div>
                    <div>step 4: display value by click the second button, the value should changed</div>
                    <window title="Hello World!!" border="normal" width="100%">
                      <button label="step 1: open Popup" popup="popup"/>
                      <n:br/>
                      <button label="step 4: display value">
                        <attribute name="onClick">
                          alert(input.getValue());
                        </attribute>
                      </button>
                      <popup id="popup">
                        <label value="step 2: edit text"/>
                        <n:br/>
                        <textbox id="input" value="abc"/>
                        <n:br/>
                        <label value="step 3: close popup by clicking outside the popup area"/>
                      </popup>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(open)"))
        waitResponse()
        val textbox = jq(".z-textbox")
        sendKeys(textbox, "abc")
        waitResponse()
        blur(textbox)
        waitResponse()
        val text = textbox.`val`()
        click(jq(".z-window-embedded:contains(Hello)").toWidget().$n("cave"))
        waitResponse()
        click(jq(".z-button:contains(display)"))
        waitResponse()

        verifyEquals("the value should changed", jq(".z-messagebox-window .z-label").text(), text)
      })

  }
}

package org.zkoss.zktest.test2.Z60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_043Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        Click inside the red div, the popup should showed at the point where you clicked.
        <div style="height:200px; width: 200px; border:1px solid red; cursor:pointer" onClick='mailPop.open(self, "at_pointer")'></div>
        <popup id="mailPop" width="150px">
          <groupbox sclass="z-demo-config" closable="false">
            <caption>This is Popup</caption>
            <html><![CDATA[ Contact Us : info@zkoss.org ]]></html>
          </groupbox>
        </popup>
      </zk>"""

    runZTL(zscript,
      () => {
        singleTap(jq("div[style*=border]"))
        waitResponse()
        verifyTrue("the popup should showed at the point where you clicked.", jq(".z-popup:contains(This)").exists())
      })

  }
}

package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1695.zul")
class B65_ZK_1695Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
    click 'select' button and you should see the input text is selected 
    <textbox id="input" value="test"/>
    <button label="select" onClick="input.select()" />
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyImage()
    })
    
  }
}
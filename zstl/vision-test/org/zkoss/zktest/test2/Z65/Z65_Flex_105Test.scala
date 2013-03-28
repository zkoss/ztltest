
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-105.zul,Flex")
class Z65_Flex_105Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Longbox]" width="480px">
        <longbox hflex="1" value="1111111111111"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Longbox, rounded]" width="480px">
        <longbox hflex="1" mold="rounded" value="1111111111111"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
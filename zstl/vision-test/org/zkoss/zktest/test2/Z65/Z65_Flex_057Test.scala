
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-057.zul,Flex")
class Z65_Flex_057Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Calendar]" width="480px">
        <calendar hflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Calendar, rounded]" width="480px">
        <calendar hflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}

package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-117.zul,Flex")
class Z65_Flex_117Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Timebox]" width="480px">
        <timebox hflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Timebox, rounded]" width="480px">
        <timebox hflex="1" mold="rounded"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}

package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-099.zul,Flex")
class Z65_Flex_099Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Intbox]" width="480px">
        <intbox hflex="1" value="1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Intbox, rounded]" width="480px">
        <intbox hflex="1" mold="rounded" value="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
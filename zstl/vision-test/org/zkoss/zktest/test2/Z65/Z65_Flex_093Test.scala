
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-093.zul,Flex")
class Z65_Flex_093Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Doublebox]" width="480px">
        <doublebox hflex="1" value="1.1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Doublebox, rounded]" width="480px">
        <doublebox hflex="1" mold="rounded" value="1.1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
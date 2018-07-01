
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-123.zul,Flex")
class Z65_Flex_123Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Doublespinner]" width="480px">
        <doublespinner hflex="1" value="0.5"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Doublespinner, rounded]" width="480px">
        <doublespinner hflex="1" mold="rounded" value="0.5"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
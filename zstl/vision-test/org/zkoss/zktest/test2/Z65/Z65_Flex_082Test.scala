
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-082.zul,Flex")
class Z65_Flex_082Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Decimalbox, rounded]" width="480px">
        <decimalbox mold="rounded" value="1111111111111" vflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Decimalbox]" width="480px">
        <decimalbox value="1111111111111" vflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
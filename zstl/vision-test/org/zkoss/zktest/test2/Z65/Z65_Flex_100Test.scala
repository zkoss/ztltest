
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-100.zul,Flex")
class Z65_Flex_100Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Longbox, rounded]" width="480px">
        <longbox mold="rounded" value="1111111111111" vflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Longbox]" width="480px">
        <longbox value="1111111111111" vflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}